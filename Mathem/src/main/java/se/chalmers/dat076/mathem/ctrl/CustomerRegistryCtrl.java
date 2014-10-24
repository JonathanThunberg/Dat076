/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package se.chalmers.dat076.mathem.ctrl;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.entityclasses.Adress;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
import se.chalmers.dat076.mathem.model.entityclasses.User;
import se.chalmers.dat076.mathem.view.CustomerRegistryBB;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.AdressesPK;
import se.chalmers.dat076.mathem.util.PasswordUtil;
/**
 *
 * @author victor_nordh92
 */
@Named
@RequestScoped
public class CustomerRegistryCtrl {
    
    private CustomerRegistryBB regBB;
    
    @Inject
    private Shop shop;
    
    @Inject
    public void setCustomerRegistryBB(CustomerRegistryBB regBB) {
        this.regBB = regBB;
    }
    
    public void submit() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(shop.getUserCatalogue().getByKey(regBB.getUsername()).isEmpty()) {
            if(shop.getAdressCatalogue().getByKey(new AdressesPK(regBB.getStreetname(), regBB.getCity())).isEmpty()) {
                Adress adress = new Adress(regBB.getStreetname(), regBB.getCity());
                adress.setPostalcode(regBB.getPostcode());
                shop.getAdressCatalogue().create(adress);
                
                User user = new User(regBB.getUsername(),PasswordUtil.PasswordToHash(regBB.getPassword()));
                shop.getUserCatalogue().create(user);
                Customer customer = new Customer(regBB.getUsername());
                customer.setName(regBB.getName());
                customer.setUsers(user);
                customer.setPhone(regBB.getPhone());
                customer.setEmail(regBB.getEmail());
                customer.setAdresses(adress);
                
                shop.getCustomerCatalogue().create(customer);
                context.getExternalContext().redirect("products.xhtml");
            }else{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Adress upptagen", ""));
                context.getExternalContext().getFlash().setKeepMessages(true);
            }
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Användarnamn upptaget", ""));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
        
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.ctrl;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import se.chalmers.dat076.mathem.model.entityclasses.Adress;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
import se.chalmers.dat076.mathem.model.entityclasses.User;
import se.chalmers.dat076.mathem.view.CustomerRegistryBB;
import se.chalmers.dat076.mathem.model.Shop;
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

    public void submit() {
            
        Adress adress = new Adress(regBB.getCity(),regBB.getStreetname());
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
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user", customer);
        RequestContext.getCurrentInstance().closeDialog("customerregistry.xhtml");
    }
}
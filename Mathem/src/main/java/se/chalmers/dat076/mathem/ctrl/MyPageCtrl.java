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
import org.primefaces.context.RequestContext;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Adress;
import se.chalmers.dat076.mathem.model.entityclasses.AdressesPK;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
import se.chalmers.dat076.mathem.model.entityclasses.User;
import se.chalmers.dat076.mathem.util.PasswordUtil;
import se.chalmers.dat076.mathem.view.MyPageBB;

/**
 *
 * @author Julia
 */

@Named
@RequestScoped
public class MyPageCtrl {
    private MyPageBB regBB;
    
    @Inject
    private Shop shop;
    
    @Inject
    public void setMyPageBB(MyPageBB regBB) {
        this.regBB = regBB;
    }
    
    public void submit() throws IOException {
        if(PasswordUtil.PasswordToHash(regBB.getPassword()).equals(shop.getUserCatalogue().getByKey(regBB.getUsername()).get(0).getPassword())){
            Adress adress = new Adress(regBB.getCity(),regBB.getStreetname());
            adress.setPostalcode(regBB.getPostcode());
            shop.getAdressCatalogue().delete(new AdressesPK(regBB.getCity(), regBB.getStreetname()));
            shop.getAdressCatalogue().create(adress);
            
            if(!regBB.getNewPassword().equals("")){
                User user = new User(regBB.getUsername());
                user.setPassword(PasswordUtil.PasswordToHash(regBB.getNewPassword()));
                shop.getUserCatalogue().delete(user.getUsername());
                shop.getUserCatalogue().create(user);
            }
            
            Customer customer = new Customer(regBB.getUsername());
            customer.setName(regBB.getName());
            customer.setPhone(regBB.getPhone());
            customer.setEmail(regBB.getEmail());
            customer.setAdresses(adress);
            shop.getCustomerCatalogue().delete(customer.getUsername());
            shop.getCustomerCatalogue().create(customer);
            FacesContext.getCurrentInstance().getExternalContext().redirect("products.xhtml");
        }else{
            //Send wrong password
        }
        
        //Feedback
    }
    
}

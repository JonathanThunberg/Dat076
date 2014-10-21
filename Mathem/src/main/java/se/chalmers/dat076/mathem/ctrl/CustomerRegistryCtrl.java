/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.ctrl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.entityclasses.Adress;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
import se.chalmers.dat076.mathem.model.entityclasses.User;
import se.chalmers.dat076.mathem.view.CustomerRegistryBB;
import se.chalmers.dat076.mathem.model.Shop;
/**
 *
 * @author victor_nordh92
 */
@Named
@RequestScoped
public class CustomerRegistryCtrl {
    
    private Customer customer;
    private CustomerRegistryBB regBB;
    private Adress adress;
    private User user;
        
    @Inject
    private Shop shop;
     
    @Inject
    public void setCustomerRegistryBB(CustomerRegistryBB regBB) {
        this.regBB = regBB;
    }

    public void submit() {
        adress = new Adress(regBB.getCity(),regBB.getStreetname());
        adress.setPostalcode(regBB.getPostcode());
        
        user = new User(regBB.getUsername(),regBB.getPassword());
        
        customer.setName(regBB.getName());
        customer.setUsername(regBB.getUsername());
        customer.setUsers(user);
        customer.setPhone(regBB.getPhone());
        customer.setEmail(regBB.getEmail());
        customer.setAdresses(adress);
        
        System.out.println("name = " + regBB.getName());
        
        shop.getCustomerCatalogue().create(customer);
        
    }
}

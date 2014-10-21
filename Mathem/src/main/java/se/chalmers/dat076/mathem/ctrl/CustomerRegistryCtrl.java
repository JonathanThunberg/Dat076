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

/**
 *
 * @author victor_nordh92
 */
@Named
@RequestScoped
public class CustomerRegistryCtrl {

    private Customer customer;
    private CustomerRegistryBB regBB;
    
    @Inject
    public void setCustomerBB(CustomerRegistryBB regBB) {
        this.regBB = regBB;
    }  
    public void submit() {
    
    customer.setName(regBB.getName());
    customer.setUsername(regBB.getUsername());
    //customer.setUsers(regBB.getUsername(),regBB.getPassword());
    customer.setPhone(regBB.getPhone());
    customer.setEmail(regBB.getEmail());
    //customer.getAdresses().getAdressesPK().
    //Adress adress = regBB.getAdress();
    //adress.setAdressesPK().setCity(regBB.getCity());
    //adress.setAdressesPK().setStreetname(regBB.getStreetname());
    //adress.setPostalcode(regBB.getPostcode());
    
}
}

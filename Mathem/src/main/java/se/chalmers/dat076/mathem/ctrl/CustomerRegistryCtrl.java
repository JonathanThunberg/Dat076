/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.ctrl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.entityclasses.Customers;

/**
 *
 * @author victor_nordh92
 */
@Named
@RequestScoped
public class CustomerRegistryCtrl {
    
    private Customers customer;
        
    public void submit(){
            
    }
}

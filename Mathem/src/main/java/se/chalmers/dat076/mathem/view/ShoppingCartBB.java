/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.ShoppingCart;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
 

/**
 *
 * @author Julia
 */
@Named
@RequestScoped
public class ShoppingCartBB implements Serializable{
     
    @Inject
    private ShoppingCart cart;
    @Inject
    private Shop shop;
    private Customer customer;
   

    public ShoppingCart getCart() {
        return cart;
    }
    
    public Customer getCustomer() {
        return customer = shop.getCustomerCatalogue().getByKey(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user").toString()).get(0);
    }
    
    

}


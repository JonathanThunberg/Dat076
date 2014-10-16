/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.OrderItem;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.ShoppingCart;
 

/**
 *
 * @author Julia
 */
@Named
@RequestScoped
public class ShoppingCartBB implements Serializable{
     
    @Inject
    private Shop shop;

     
    @PostConstruct
    public void init() {
        ;
    }
     
    public List<OrderItem> getItems() {
        return null;
        //return shop.getCustomer().getCart().getOrderItems();
    }
   

    public ShoppingCart getCart() {
        return null;
        //return shop.getCustomer().getCart();
    }
    
    

}


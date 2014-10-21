/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.ShoppingCart;
 

/**
 *
 * @author Julia
 */
@Named
@RequestScoped
public class ShoppingCartBB implements Serializable{
     
    @Inject
    private ShoppingCart cart;
   

    public ShoppingCart getCart() {
        return cart;
    }
    
    

}


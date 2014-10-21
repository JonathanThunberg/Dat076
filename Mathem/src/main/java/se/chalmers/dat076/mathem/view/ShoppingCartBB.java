/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
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
    private Shop shop;
    
    @PostConstruct
    public void init() {
        ;
    }
   

    public ShoppingCart getCart() {
        return ((Customer)shop.getUserCatalogue().getByKey(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user")).get(0)).getCart();
    }
    
    

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.ctrl;

import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.OrderItem;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.ShoppingCart;
import se.chalmers.dat076.mathem.model.entityclasses.Product;
import se.chalmers.dat076.mathem.view.SearchBB;

/**
 *
 * @author victor_nordh92
 */
@Named
@RequestScoped
public class SearchCtrl{
    @Inject
    private Shop shop;
    
    private SearchBB sBB;
    
    @Inject
    private ShoppingCart cart;
    
    @Inject
    public void setSearchBB(SearchBB sBB) {
        this.sBB = sBB;
    }
   
    public void buy(OrderItem product) {
        cart.add(product);
    }
}

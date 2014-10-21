/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.ctrl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.OrderItem;
import se.chalmers.dat076.mathem.model.ShoppingCart;
import se.chalmers.dat076.mathem.model.entityclasses.Product;
import se.chalmers.dat076.mathem.view.ProductsBB;

/**
 *
 * @author Julia
 */

@Named
@RequestScoped
public class ProductsCtrl {
    
    private ProductsBB productsBB;
    
    @Inject
    private ShoppingCart cart;
    
    @Inject
    public void setProductsBB(ProductsBB productsBB) {
        this.productsBB = productsBB;
    }
    
    public void buy(Product product) {
        System.out.println(product.toString() +" "+ productsBB.getAmount());
        cart.add(new OrderItem(product, productsBB.getAmount()));
    }
    
}

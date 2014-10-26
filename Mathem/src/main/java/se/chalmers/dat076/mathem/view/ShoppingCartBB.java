
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.ShoppingCart;
 

/**
 *Responsibility: Only used to get the cart in ShoppingCartCtrl and shoppingCart.xhtml
 *Used by:ShoppingCartCtrl and shoppingCart.xhtml
 *Uses: shop, ShoppingCart
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


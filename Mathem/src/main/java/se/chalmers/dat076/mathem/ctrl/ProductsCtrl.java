
package se.chalmers.dat076.mathem.ctrl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.OrderItem;
import se.chalmers.dat076.mathem.model.ShoppingCart;

/**
 * Responsibility: add products to shopping cart
 * Uses: Shop, ShoppingCart
 * Used by: products.xhtml, productsDetail.xhtml
 */

@Named
@RequestScoped
public class ProductsCtrl {
    
    @Inject
    private ShoppingCart cart;
    
    public void buy(OrderItem product) {
        cart.add(product);
    }
    
}

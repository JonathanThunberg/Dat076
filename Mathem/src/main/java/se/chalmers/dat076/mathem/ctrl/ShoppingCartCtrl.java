
package se.chalmers.dat076.mathem.ctrl;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.OrderItem;
import se.chalmers.dat076.mathem.view.ShoppingCartBB;

/**
 * Responsibility: Handles the shopping cart
 * Uses: ShoppingCartBB
 * Used by: shoppingCart.xhtml
 */

@Named
@RequestScoped
public class ShoppingCartCtrl {
    
    private ShoppingCartBB cartBB;
    
    
    @Inject
    public void setCartBB(ShoppingCartBB cartBB) {
        this.cartBB = cartBB;
    }
    
    public void deleteItem(OrderItem item) {
        cartBB.getCart().remove(item);
    }
    
    public void emptyCart() {
        cartBB.getCart().emptyCart();
    }
    
    public void buy() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("buyConfirmation.xhtml");
    }
    
    public void cancel() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("shoppingCart.xhtml");
    }
    
    public void setQuantity(OrderItem item, int quantity) {
        cartBB.getCart().changeQuantity(item, quantity);
    }
    
}

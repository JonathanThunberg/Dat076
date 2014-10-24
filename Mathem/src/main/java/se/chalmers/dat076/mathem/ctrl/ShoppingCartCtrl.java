/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.ctrl;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import se.chalmers.dat076.mathem.model.OrderItem;
import se.chalmers.dat076.mathem.view.ShoppingCartBB;

/**
 *
 * @author Julia
 */

@Named
@RequestScoped
public class ShoppingCartCtrl {
    
    private ShoppingCartBB cartBB;

    @Inject
    public void setProductBB(ShoppingCartBB cartBB) {
        this.cartBB = cartBB;
    }    
    
    public void deleteItem(OrderItem item) {
        cartBB.getCart().remove(item);
    }
    
    public void emptyCart() {
        cartBB.getCart().emptyCart();
    }
    
    public void buy() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("buyconfirmation.xhtml");
    } 
    
    public void confirm(){
        
    }
    
    public void cancel() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("shoppingcart.xhtml");
    }
    
    public void setQuantity(OrderItem item, int quantity) {
        
        cartBB.getCart().changeQuantity(item, quantity);
    }
    
}

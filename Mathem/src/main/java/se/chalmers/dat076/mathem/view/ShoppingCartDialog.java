
package se.chalmers.dat076.mathem.view;

import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;

/**
 *Responsibility: Only used to open the dialog for the shopping cart
 *Used by:Template.xhtml
 */
@ManagedBean
public class ShoppingCartDialog {
    
    public void openCart() {
        
        RequestContext.getCurrentInstance().openDialog("shoppingCart.xhtml");
    }

}


package se.chalmers.dat076.mathem.ctrl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.OrderItem;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
import se.chalmers.dat076.mathem.model.entityclasses.CustomerOrder;
import se.chalmers.dat076.mathem.model.entityclasses.OrderQuantity;
import se.chalmers.dat076.mathem.view.BuyConfirmationBB;

/**
 * Responsibility: confirm a purchase
 * Uses: Shop, BuyConfirmationBB, Customer, OrderItem
 * Used by: buyConfirmation.xhtml
 */

@Named
@RequestScoped
public class BuyConfirmationCtrl {

    private BuyConfirmationBB buyConBB;

    @Inject
    private Shop shop;

    @Inject
    public void setBuyConfirmationtBB(BuyConfirmationBB buyConBB) {
        this.buyConBB = buyConBB;
    }

    public void confirm() throws IOException {
        

        //Validate() towards bank
        List<OrderItem> orderItems = buyConBB.getCart().getOrderItems();        
        Customer customer = shop.getCustomerCatalogue().getByKey(buyConBB.getCustomer().getUsername()).get(0);        
        CustomerOrder o = new CustomerOrder();
        if(o.getCustomersCollection()==null){
            o.setCustomersCollection(new ArrayList<Customer>());
        }
        
        o.getCustomersCollection().add(customer);

        shop.getOrderCatalogue().create(o);
        
        shop.getCustomerCatalogue().update(customer);
        
        for (OrderItem i : orderItems) {
            OrderQuantity oQ = new OrderQuantity(i.getProduct().getId(), o.getId());
            oQ.setCustomerOrder(o);
            oQ.setAmount(i.getQuantity());
            oQ.setProduct(i.getProduct());
            shop.getOrderQuantityCatalogue().create(oQ);
        }
        
        buyConBB.getCart().emptyCart();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Ditt köp har gått igenom", ""));
        context.getExternalContext().getFlash().setKeepMessages(true);
        FacesContext.getCurrentInstance().getExternalContext().redirect("shoppingcart.xhtml");
    }

    public void cancel() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("shoppingcart.xhtml");
        } catch (Exception e) {
            Logger.getLogger(BuyConfirmationCtrl.class.getName()).log(Level.SEVERE, e.toString());
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.ctrl;

import java.io.IOException;
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
import se.chalmers.dat076.mathem.model.entityclasses.Account;
import se.chalmers.dat076.mathem.model.entityclasses.CustomerOrder;
import se.chalmers.dat076.mathem.model.entityclasses.OrderQuantity;
import se.chalmers.dat076.mathem.model.entityclasses.Payswith;
import se.chalmers.dat076.mathem.view.BuyConfirmationBB;

/**
 *
 * @author tuna
 */
@Named
@RequestScoped
public class BuyConfirmationCtrl {

    private static final Logger LOG = Logger.getLogger(BuyConfirmationCtrl.class.getName());

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
        CustomerOrder o = new CustomerOrder();
        shop.getOrderCatalogue().create(o);
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


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
 *Responsibility: Keeps some data for BuyConfirmation.xhtlm and BuyConfirmationCtrl 
 *Used by: BuyConfirmation.xhtlm, BuyConfirmationCtrl 
 *Uses: shop, CustomerCatalogue, ShoppingCart, Customer
 */
@Named
@RequestScoped
public class BuyConfirmationBB implements Serializable{
    @Inject
    private Shop shop;
    
    private String cardnumber;

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
    private String name;
    private String expdate;
    private String cvc;
    
    private boolean saveInfo;
    
    @Inject
    private ShoppingCart cart;
    
    
    private Customer customer;
    
   
    public ShoppingCart getCart() {
        return cart;
    }
    
       
    public Customer getCustomer() {
        return customer;
    }

    
    @PostConstruct
    public void init() {
        customer = shop.getCustomerCatalogue().getByKey(
                FacesContext.getCurrentInstance().getExternalContext()
                        .getSessionMap().get("user").toString()).get(0);
    }
    
    public String getCardnumber() {
        return cardnumber;
    }
    
    public String getName() {
        return name;
    }
    
    public String getExpdate() {
        return expdate; 
    }
    
    public String getCvc() {
        return cvc;
    }
    
    public boolean getSaveInfo() {
        return saveInfo;
    }

    public void setSaveInfo(boolean saveInfo) {
        this.saveInfo = saveInfo;
    }
    
}

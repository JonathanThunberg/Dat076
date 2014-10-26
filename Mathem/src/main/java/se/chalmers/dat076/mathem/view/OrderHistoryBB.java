
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.CustomerOrder;

/**
 *Responsibility: Keeps some data for OrderHistory.xhtlm 
 *Used by: OrderHistory.xhtlm
 *Uses: shop, CustomerOrder, OrderCatalogue
 */
@Named
@RequestScoped
public class OrderHistoryBB implements Serializable{
    
    @Inject
    private Shop shop;
    
    private List<CustomerOrder> customerOrders = new ArrayList();

    public List<CustomerOrder> getCustomerOrders() {
        List<CustomerOrder> p = shop.getOrderCatalogue().getByCustomer(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user").toString());
        return p;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }      
    
    }

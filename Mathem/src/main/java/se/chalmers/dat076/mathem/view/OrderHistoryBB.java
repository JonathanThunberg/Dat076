/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import se.chalmers.dat076.mathem.model.entityclasses.OrderQuantity;

/**
 *
 * @author victor_nordh92
 */
@Named
@RequestScoped
public class OrderHistoryBB implements Serializable{
    
    @Inject
    private Shop shop;
    
    private List<CustomerOrder> customerOrders = new ArrayList();

    public List<CustomerOrder> getCustomerOrders() {
        System.out.println("Nu är vi i getCustomerOrders");
        List<CustomerOrder> p = shop.getOrderCatalogue().getByCustomer(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user").toString());
         System.out.println("Nu har vi fått listan med antal element: " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user").toString());
        return p;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        System.out.println("Nu är vi i setCustomerOrders");
        this.customerOrders = customerOrders;
    }      
    
    }

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
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.OrderQuantity;

/**
 *
 * @author victor_nordh92
 */
@Named
@RequestScoped
public class OrderDetailBB implements Serializable{
   
    @Inject
    private Shop shop;
    
    private int id;
    private List<OrderQuantity> orderQuantities = new ArrayList();
    private double price;

    public double getPrice() {
        for(OrderQuantity oq : getOrderQuantities()){
            price = oq.getAmount()*oq.getProduct().getPrice();
        }
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<OrderQuantity> getOrderQuantities() {
        return shop.getOrderQuantityCatalogue().getByOrder(id);
    }

    public void setOrderQantities(List<OrderQuantity> orderQuantities) {
        this.orderQuantities = orderQuantities;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
   
    
}

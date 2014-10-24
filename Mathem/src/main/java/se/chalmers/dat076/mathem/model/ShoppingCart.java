/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;


/**
 *
 * @author Julia
 */

@SessionScoped
public class ShoppingCart implements Serializable{
    
    private List<OrderItem> items = new ArrayList<>();
    
    public void add(OrderItem item) {
        boolean itemAdded = false;
        for(int i = 0; i<items.size(); i++) {
            if(items.get(i).getProduct().getName().equalsIgnoreCase(item.getProduct().getName())) {
                changeQuantity(items.get(i), items.get(i).getQuantity()+item.getQuantity());
                itemAdded = true;
            }
        }
        if(!itemAdded) {
            items.add(item);
        }  
    }

    public void remove(OrderItem item) { 
        items.remove(item);
    }
    
    public void changeQuantity(OrderItem item, int quantity) {
        item.setQuantity(quantity);
    }


    public List<OrderItem> getOrderItems() {
        return items;
    }
     
    public void emptyCart() {
        items.clear();
    }
    
    public double getPrice(OrderItem item){
            return new BigDecimal(item.getQuantity()*item.getProduct().getPrice()).setScale(3, RoundingMode.HALF_UP).doubleValue();
    
    }
    
    public double getTotalPrice() {
        double price = 0;
        for(OrderItem o: items){
            price+=o.getQuantity()*o.getProduct().getPrice();
        }
        return new BigDecimal(price).setScale(3, RoundingMode.HALF_UP).doubleValue();
    }

    
}

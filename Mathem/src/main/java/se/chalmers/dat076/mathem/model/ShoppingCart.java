/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author Julia
 */
public class ShoppingCart implements Serializable{
    
    private List<OrderItem> items;
    
    public void add(OrderItem item) {
        boolean itemAdded = false;
        for(int i = 1; i<items.size(); i++) {
            if(items.get(i).getProduct().getName().equalsIgnoreCase(item.getProduct().getName())) {
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

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model;

import java.io.Serializable;
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
    private double price = 0;
    
    public void add(OrderItem item) {
        boolean itemAdded = false;
        for(int i = 0; i<items.size(); i++) {
            System.out.println(item.getProduct().getName());
            if(items.get(i).getProduct().getName().equalsIgnoreCase(item.getProduct().getName())) {
                changeQuantity(items.get(i), items.get(i).getQuantity()+item.getQuantity());
                itemAdded = true;
            }
        }
        if(!itemAdded) {
            items.add(item);
            price = price+(item.getQuantity()*item.getProduct().getPrice());
        }  
    }

    public void remove(OrderItem item) { 
        items.remove(item);
    }
    
    public void changeQuantity(OrderItem item, int quantity) {
        price = price + ((quantity-item.getQuantity())*item.getProduct().getPrice());
        item.setQuantity(quantity);
    }


    public List<OrderItem> getOrderItems() {
        for(OrderItem i: items) {
            //System.out.println(i.getProduct().getName());
        }
        System.out.println(items.size());
        return items;
    }
     
    public void emptyCart() {
        items.clear();
    }
    
    public double getTotalPrice() {
        return price;
    }

    
}

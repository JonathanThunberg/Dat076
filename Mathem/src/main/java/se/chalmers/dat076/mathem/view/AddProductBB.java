/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package se.chalmers.dat076.mathem.view;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Category;

/**
 *
 * @author Julia
 */

@Named
@RequestScoped
public class AddProductBB {
    
    @Inject
    private Shop shop;
    
    private String name;
    private double price;
    private Category category;
    private List<String> categories = new ArrayList<>();
    
    public List<String> getCategories() {
        for(Category c: shop.getCategoryCatalogue().findAll()) {
            categories.add(c.getName());
        }
        return categories;
    }
    
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
    
    
    public String getName() {
        System.out.println("get name: " + name);
        return name;
    }
    
    public void setName(String name) {
        System.out.println("set name: " + name);
        this.name = name;
    }
    
    public double getPrice() {
        System.out.println("get price: " + price);
        return price;
    }
    
    public void setPrice(double price) {
        System.out.println("set price: " + price);
        this.price = price;
    }
    
    public Category getCategory() {
        System.out.println("get category: " + category);
        return category;
    }
    
    public void setCategory(Category category) {
        System.out.println("set category: " + category);
        this.category = category;
    }
    
    
    
}

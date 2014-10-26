
package se.chalmers.dat076.mathem.view;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Category;

/**
 *Responsibility: Keeps some data for AddProduct.xhtlm and AddProductCtrl 
 *Used by: AddProduct.xhtlm, AddProductCtrl 
 *Uses: shop, CategoryCatalogue
 *    
 */

@Named
@RequestScoped
public class AddProductBB {
    
    @Inject
    private Shop shop;
    
    private String name;
    private double price;
    private String category;
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
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    
    
}

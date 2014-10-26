
package se.chalmers.dat076.mathem.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *Responsibility: Keeps some data for EditProduct.xhtlm and EditProductCtrl 
 *Used by: EditProduct.xhtlm, EditProductCtrl 
 */
@Named
@RequestScoped
public class EditProductBB {
    private String name;
    private int id;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}

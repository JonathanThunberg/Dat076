
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.OrderItem;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

/**
 *Responsibility: Keeps some data for productsDetail.xhtlm and SearchCtrl 
 *Used by:Products.xhtlm, Products.xhtlm, SearchCtrl 
 *Uses: shop, OrderItem, ProductCatalogue
 */
@Named
@RequestScoped
public class SearchBB implements Serializable{
    
    private Product prod;
    private String productname;
    
    private List<OrderItem> products= new ArrayList<>();

    public List<OrderItem> getProducts() {
        return products;
    }

    public void setProducts(List<OrderItem> products) {
        this.products = products;
    }
    
    
    @Inject 
    private Shop shop;
    
    public void setProductname(String productname){
        this.productname = productname;
        for (Product p : shop.getProductCatalogue().getByName(productname)) {
                products.add(new OrderItem(p,1));
        }
    }
    
    public String getProductname(){
        return productname;   
    }
}

package se.chalmers.dat076.mathem.view;

/**
 *
 * @author victor_norxdh92
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import se.chalmers.dat076.mathem.model.OrderItem;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Category;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

@ManagedBean
@ViewScoped
public class ProductsBB implements Serializable {
    
    @Inject
    private Shop shop;
    private List<OrderItem> products= new ArrayList<>();
    private String category;
    
    @PostConstruct
    public void init() {
        category = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("category");
    }
    
    public List<OrderItem> getProducts() {
        products.clear();
        for (Category c : shop.getCategoryCatalogue().findAll()) {
            if(c.getName().equals(category)){
                for (Product p : shop.getProductCatalogue().getByCategory(category)) {
                    products.add(new OrderItem(p,1));
                }
                return products;
            }
        }
        
        for (Product p : shop.getProductCatalogue().findAll()) {
            products.add(new OrderItem(p,1));
        }
        
        return products;
        
    }
    
    public void setProducts(List<OrderItem> p) {
        products = p;
    }

    
    public String getCategory() {
        return category;
    }
    
    
    public void setCategory(String category) {
        this.category = category;
    }

    
   
}

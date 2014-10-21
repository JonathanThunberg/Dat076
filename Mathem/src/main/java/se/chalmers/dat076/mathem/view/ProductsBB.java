package se.chalmers.dat076.mathem.view;

/**
 *
 * @author victor_nordh92
 */
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Category;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

@ManagedBean
@ViewScoped
public class ProductsBB implements Serializable {

    @Inject
    private Shop shop;
    private List<Product> products;
    private Product selectedProd;
    private String category;
    private int amount = 1;


    public List<Product> getProducts() {
        System.out.print("1");
        for(Category c : shop.getCategoryCatalogue().findAll()){
            if(c.getName().equals(category)){
                return shop.getProductCatalogue().getByCategory(category);
            }
        }
        return shop.getProductCatalogue().findAll();
    }
    
    public void setProducts(List<Product> p) {
        products = p;
    }

    public Product getSelectedProd() {
        return selectedProd;
    }

    public void setSelectedProd(Product selectedProd) {
        this.selectedProd = selectedProd;
    }

    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
        System.out.println("5");
        this.category = category;
    }
    
    public void editCategory() {
        System.out.println("4");
        category = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("category");
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
}

package se.chalmers.dat076.mathem.view;

/**
 *
 * @author victor_nordh92
 */
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
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
        for (Category c : shop.getCategoryCatalogue().findAll()) {
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
        this.category = category;
    }
    
    public void editCategory() {
        category = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("category");
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
}

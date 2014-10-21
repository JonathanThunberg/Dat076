package se.chalmers.dat076.mathem.menu;

/**
 *
 * @author victor_nordh92
 */
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

@ManagedBean
@ViewScoped
public class DataGridView implements Serializable {

    @Inject
    private Shop shop;

    private static final Logger LOG = Logger.getLogger(DataGridView.class.getName());

    private List<Product> products;
    private Product selectedProd;
    private String category = "all";

    @PostConstruct
    public void init() {
        if (category.equals("all")) {
            this.products = this.shop.getProductCatalogue().findAll();

        } else {
            this.products = this.shop.getProductCatalogue().getByCategory(category);
        }
    }

    public List<Product> getProducts() {
        return products;
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

    public void save(ActionEvent event) {
    }

    public void setCategory(String s) {
        category = s;
    }
}

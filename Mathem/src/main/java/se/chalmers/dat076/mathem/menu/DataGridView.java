package se.chalmers.dat076.mathem.menu;
/**
 *
 * @author victor_nordh92
 */

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

    private List<Product> products; 
    private Product selectedProd;

    @PostConstruct
    public void init() {   
        this.products = this.shop.getProductCatalogue().findAll();
    }

    public List<Product> getProducts() {
    return products;
}
    public Product getSelectedProd() {
        return selectedProd;
    }
 
    public void setSelectedProd(Product selectedProd) {
        this.selectedProd = selectedProd;
    }
}
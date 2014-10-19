package se.chalmers.dat076.mathem.view;
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
import se.chalmers.dat076.mathem.model.entityclasses.Products;
 
@ManagedBean
@ViewScoped
public class DataGridView implements Serializable {
    
    @Inject
    private Shop shop;    
    private List<Products> prodList;    
    private static final Logger LOG = Logger.getLogger(DataGridView.class.getName());
    
    private Products selectedProd;
     
    @PostConstruct
    public void init() {   
        //this.prodList = this.shop.getProductCatalogue().findAll();
    }

    public Products getSelectedProd() {
        return selectedProd;
    }
 
    public void setSelectedProd(Products selectedProd) {
        this.selectedProd = selectedProd;
    }
}
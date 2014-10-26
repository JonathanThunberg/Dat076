
package se.chalmers.dat076.mathem.ctrl;

import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Product;
import se.chalmers.dat076.mathem.view.SearchBB;

/**
 * Responsibility: searches for products
 * Uses: Shop, SearchBB
 * Used by: productDetail.xhtml
 */

@Named
@RequestScoped
public class SearchCtrl{
    @Inject
    private Shop shop;
    
    private SearchBB sBB;
    
    @Inject
    public void setSearchBB(SearchBB sBB) {
        this.sBB = sBB;
    }
    
    public void search() throws IOException{
        System.out.println("Nu är vi i search");
        List<Product> p = shop.getProductCatalogue().getByName(sBB.getProductname());
        
        if(p.isEmpty()){
            System.out.println("Nu är det tomt");            
        }
        else{
            System.out.println("Produkten p.get =  "+ p.get(0).getName());
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("searchitem", p.get(0).getId());          
        }
    }
}

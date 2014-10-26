/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package se.chalmers.dat076.mathem.ctrl;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Product;
import se.chalmers.dat076.mathem.view.AddProductBB;

/**
 *
 * @author Julia
 */
@Named
@RequestScoped
public class AddProductCtrl {
    
    @Inject
    private Shop shop;
    private AddProductBB addProductBB;
    
    @Inject
    public void setAddProductBB(AddProductBB addProductBB) {
        this.addProductBB = addProductBB;
    }
    
    public void add() {
        
        Product product = new Product();
        product.setName(addProductBB.getName());
        product.setPrice(addProductBB.getPrice());
        product.setCategory(shop.getCategoryCatalogue().getByKey(addProductBB.getCategory()).get(0));
        shop.getProductCatalogue().create(product);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Varan är tillagd", ""));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
    }
    
}

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
import se.chalmers.dat076.mathem.view.EditProductBB;

/**
 *
 * @author Julia
 */
@Named
@RequestScoped
public class EditProductCtrl {
    
    @Inject
    private Shop shop;
    private EditProductBB editProductBB;
    
    @Inject
    public void setEditProductBB(EditProductBB editProductBB) {
        this.editProductBB = editProductBB;
    }
    
    public void edit() {
        System.out.println("I edit");
        Product p = new Product(editProductBB.getId(), editProductBB.getName(), editProductBB.getPrice());
        p.setCategory(shop.getProductCatalogue().getByKey(editProductBB.getId()).get(0).getCategory());
        shop.getProductCatalogue().update(p);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Varan är ändrad", ""));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        
    }
    
}

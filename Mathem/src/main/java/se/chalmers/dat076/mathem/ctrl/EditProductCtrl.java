/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package se.chalmers.dat076.mathem.ctrl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Product;
import se.chalmers.dat076.mathem.view.EditProductBB;
import se.chalmers.dat076.mathem.view.ProductsBB;

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
        Product product = shop.getProductCatalogue().getByKey(editProductBB.getId()).get(0);
        System.out.println(editProductBB.getName() + editProductBB.getPrice());
        product.setName(editProductBB.getName());
        product.setPrice(editProductBB.getPrice());
        
    }
    
}

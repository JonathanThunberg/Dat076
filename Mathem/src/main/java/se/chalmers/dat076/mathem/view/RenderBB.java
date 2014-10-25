/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package se.chalmers.dat076.mathem.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;

/**
 *
 * @author Julia
 */

@Named
@RequestScoped
public class RenderBB {
    
    @Inject
    private Shop shop;
    
    public boolean isUserLoggedIn() {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey("user");
    }
    
    public boolean isUserCustomer() {
        if(isUserLoggedIn()) {
            return !(shop.getCustomerCatalogue().getByKey(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user").toString()).isEmpty());
        }else{
             return false;
        }
    }
    
    public boolean isUserAdmin() {
        if(isUserLoggedIn()) {
            return !(shop.getAdminCatalogue().getByKey(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user").toString()).isEmpty());
        }else{
            return false;
        }
    }

    
}

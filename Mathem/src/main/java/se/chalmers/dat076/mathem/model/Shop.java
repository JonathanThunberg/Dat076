/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package se.chalmers.dat076.mathem.model;

import se.chalmers.dat076.mathem.model.catalogue.ICatalogue;
import se.chalmers.dat076.mathem.model.catalogue.ICustomerCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IRecipeCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IProductCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IAdressesCatalogue;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import se.chalmers.dat076.mathem.model.catalogue.ICategoryCatalogue;


/**
 *
 * @author tuna
 */
@ApplicationScoped
public class Shop {
    
    @EJB
    private IProductCatalogue pC;
    
    @EJB
    private ICustomerCatalogue cC;
    
    @EJB
    private ICategoryCatalogue caC;
    
    @EJB
    private IRecipeCatalogue rC;
    
    @EJB
    private ICatalogue uC;
    
    @EJB
    private IAdressesCatalogue aC;
    
    public IAdressesCatalogue getAdressCatalogue() {
        return aC;
    }
    
    public ICategoryCatalogue getCategoryCatalogue() {
        return caC;
    }
    
    public IProductCatalogue getProductCatalogue() {
        return pC;
    }
    
    public ICustomerCatalogue getCustomerCatalogue() {
        return cC;
    }
    
    public IRecipeCatalogue getRecipeCatalogue() {
        return rC;
    }
    
    public ICatalogue getUserCatalogue() {
        return uC;
    }
    
}

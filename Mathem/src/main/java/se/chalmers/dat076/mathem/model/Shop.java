/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package se.chalmers.dat076.mathem.model;

import se.chalmers.dat076.mathem.model.catalogue.ICustomerCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IRecipeCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IProductCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IAdressesCatalogue;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import se.chalmers.dat076.mathem.model.catalogue.IAccountCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IAdminCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.ICategoryCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IOrderCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IOrderQuantityCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IPayswithCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IUserCatalogue;
import se.chalmers.dat076.mathem.model.entityclasses.Admin;
import se.chalmers.dat076.mathem.model.entityclasses.User;
import se.chalmers.dat076.mathem.util.PasswordUtil;


/**
 *
 * @author tuna
 */
@ApplicationScoped
public class Shop {
    
    @EJB
    private IProductCatalogue pC;
    
    @EJB
    private IAccountCatalogue acC;
    
    @EJB
    private ICustomerCatalogue cC;
    
    @EJB
    private ICategoryCatalogue caC;
    
    @EJB
    private IRecipeCatalogue rC;
    
    @EJB
    private IUserCatalogue uC;
    
    @EJB
    private IAdressesCatalogue aC;
    
    @EJB
    private IAdminCatalogue adC;
    @EJB
    private IPayswithCatalogue pwc;
    @EJB
    private IOrderCatalogue oC;
    @EJB
    private IOrderQuantityCatalogue oQC;
    
    public IAdminCatalogue getAdminCatalogue() {
        return adC;
    }
    
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
    
    public IUserCatalogue getUserCatalogue() {
        return uC;
    }
    
    public IAccountCatalogue getAccountCatalogue() {
        return acC;
    }

    public IPayswithCatalogue getPaysWithCatalogue() {
        return pwc;
    }

    public IOrderCatalogue getOrderCatalogue() {
        return oC;
    }

    public IOrderQuantityCatalogue getOrderQuantityCatalogue() {
        return oQC;
    }

}

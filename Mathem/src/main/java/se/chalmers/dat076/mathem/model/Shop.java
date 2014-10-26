package se.chalmers.dat076.mathem.model;


import se.chalmers.dat076.mathem.model.catalogue.ICustomerCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IRecipeCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IProductCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IAdressesCatalogue;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import se.chalmers.dat076.mathem.model.catalogue.IAdminCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.ICategoryCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IOrderCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IOrderQuantityCatalogue;
import se.chalmers.dat076.mathem.model.catalogue.IUserCatalogue;

/**
 * Responsibilty: Managing all catalogues
 * Uses: All Catalogues
 * Used by: All ControlBean except ShoppingCartCtrl and ProductsCtrl, 
 *          AddProductBB, BuyConfirmationBB, MyPageBB, OrderDetailBB, OrderHistoryBB,
 *          ProductDetailBB, ProductsBB, RecipeBB, RenderBB, ShoppingCartBB, SearchDetailBB,
 *          template.xhtml, aboutus.xhtml, contactus.xhtml, generalconditions.xhtml, safeshopping.xhtml, 
 *          shoppingcart.xhtml, workhere.xhtml 
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
    private IUserCatalogue uC;
    
    @EJB
    private IAdressesCatalogue aC;
    
    @EJB
    private IAdminCatalogue adC;
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
    
    public IOrderCatalogue getOrderCatalogue() {
        return oC;
    }

    public IOrderQuantityCatalogue getOrderQuantityCatalogue() {
        return oQC;
    }

}

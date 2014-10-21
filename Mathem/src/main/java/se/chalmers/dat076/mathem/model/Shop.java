/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.chalmers.dat076.mathem.model;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;


/**
 *
 * @author tuna
 */
@ApplicationScoped 
public class Shop{
    @EJB
    private IProductCatalogue pC;
    
    @EJB
    private ICustomerCatalogue cC;
    
    @EJB
    private IRecipeCatalogue rC;
    
    @EJB
    private ICatalogue uC;
       
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

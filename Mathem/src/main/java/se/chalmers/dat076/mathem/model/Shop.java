/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.chalmers.dat076.mathem.model;

import java.util.Collection;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import se.chalmers.dat076.mathem.model.entityclasses.Products;

/**
 *
 * @author tuna
 */
@ApplicationScoped 
public class Shop {
    @EJB
    private ProductCatalogue pC;
    
    public ProductCatalogue getProductCatalogue() {
        return pC;
    }
    
}

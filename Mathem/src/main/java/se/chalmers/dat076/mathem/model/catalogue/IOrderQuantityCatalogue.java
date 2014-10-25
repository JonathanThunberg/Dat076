/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model.catalogue;

import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.OrderQuantity;
import se.chalmers.dat076.mathem.model.entityclasses.OrderQuantityPK;

/**
 *
 * @author tuna
 */
@Local
public interface IOrderQuantityCatalogue extends ICatalogue<OrderQuantity, OrderQuantityPK> {
    
}

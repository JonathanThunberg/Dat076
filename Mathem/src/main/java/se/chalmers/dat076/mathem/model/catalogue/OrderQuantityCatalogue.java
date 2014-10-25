/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.chalmers.dat076.mathem.model.entityclasses.CustomerOrder;
import se.chalmers.dat076.mathem.model.entityclasses.OrderQuantity;
import se.chalmers.dat076.mathem.model.entityclasses.OrderQuantityPK;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *
 * @author tuna
 */
@Stateless
public class OrderQuantityCatalogue extends AbstractDAO<OrderQuantity, OrderQuantityPK>
    implements IOrderQuantityCatalogue{
    
    @PersistenceContext
    protected EntityManager eM;
    
    public OrderQuantityCatalogue() {
        super(OrderQuantity.class);
    }
    
    
    @Override
    public List<OrderQuantity> getByKey(OrderQuantityPK id) {
        List<OrderQuantity> found = new ArrayList<>();
        for (OrderQuantity o : findRange(0, count())) {
            if (o.getHasPK().equals(id)) {
                found.add(o);
            }
        }
        return found;
    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return eM;
    } 
}

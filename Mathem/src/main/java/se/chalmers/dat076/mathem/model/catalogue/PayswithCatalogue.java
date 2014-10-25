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
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
import se.chalmers.dat076.mathem.model.entityclasses.Payswith;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *
 * @author tuna
 */
@Stateless
public class PayswithCatalogue extends AbstractDAO<Payswith, Customer>
            implements IPayswithCatalogue{

        @PersistenceContext
        protected EntityManager eM;

        public PayswithCatalogue() {
            super(Payswith.class);
        }

        @Override
        public List<Payswith> getByKey(Customer id) {
            List<Payswith> found = new ArrayList<>();
            for (Payswith p : findRange(0, count())) {
                if (p.getCustomer().equals(id)) {
                    found.add(p);
                }
            }
            return found;
        }

        @Override
        protected EntityManager getEntityManager() {
            return eM;
        }
    
    
    
}

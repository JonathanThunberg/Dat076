package se.chalmers.dat076.mathem.model.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *Responsibility: Handles the persistence for the entity class Customer
 *Used by: Shop, BuyConfirmationCtrl,CustomerRegistryCtrl,MyPageCtrl,
 * BuyConfirmationCtrl,MyPageBB, RenderBB 
 *Uses: Customer
 */

    @Stateless
    public class CustomerCatalogue extends AbstractDAO<Customer, String>
            implements ICustomerCatalogue{

        @PersistenceContext
        protected EntityManager eM;

        public CustomerCatalogue() {
            super(Customer.class);
        }

        @Override
        public List<Customer> getByKey(String id) {
            List<Customer> found = new ArrayList<>();
            for (Customer u : findRange(0, count())) {
                if (u.getUsername().equals(id)) {
                    found.add(u);
                }
            }
            return found;
        }

        @Override
        protected EntityManager getEntityManager() {
            return eM;
        }
    }

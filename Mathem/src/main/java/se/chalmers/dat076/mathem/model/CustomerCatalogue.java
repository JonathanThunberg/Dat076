/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
import se.chalmers.dat076.mathem.model.entityclasses.User;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *
 * @author victor_nordh92
 */

    @Stateless
    public class CustomerCatalogue extends AbstractDAO<Customer, String>
            implements ICatalogue<Customer, String> {

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

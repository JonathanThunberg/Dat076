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
import se.chalmers.dat076.mathem.model.entityclasses.Account;
import se.chalmers.dat076.mathem.model.entityclasses.Admin;
import se.chalmers.dat076.mathem.model.entityclasses.Category;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *
 * @author tuna
 */
@Stateless
public class AccountCatalogue extends AbstractDAO<Account, String>
            implements IAccountCatalogue{

        @PersistenceContext
        protected EntityManager eM;

        public AccountCatalogue() {
            super(Account.class);
        }

        @Override
        public List<Account> getByKey(String id) {
            List<Account> found = new ArrayList<>();
            for (Account c : findRange(0, count())) {
                if (c.getCardnumber().equals(id)) {
                    found.add(c);
                }
            }
            return found;
        }

        @Override
        protected EntityManager getEntityManager() {
            return eM;
        }
    
}

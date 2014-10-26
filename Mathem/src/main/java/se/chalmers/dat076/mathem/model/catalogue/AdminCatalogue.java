
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.chalmers.dat076.mathem.model.entityclasses.Admin;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *Responsibility: Handles the persistence for the entity class Account
 *Used by: Shop, RenderBB
 *Uses: Admin
 */
@Stateless
public class AdminCatalogue extends AbstractDAO<Admin, String>
            implements IAdminCatalogue{

        @PersistenceContext
        protected EntityManager eM;

        public AdminCatalogue() {
            super(Admin.class);
        }

        @Override
        public List<Admin> getByKey(String id) {
            List<Admin> found = new ArrayList<>();
            for (Admin a : findRange(0, count())) {
                if (a.getUsername().equals(id)) {
                    found.add(a);
                }
            }
            return found;
        }

        @Override
        protected EntityManager getEntityManager() {
            return eM;
        }
    
}

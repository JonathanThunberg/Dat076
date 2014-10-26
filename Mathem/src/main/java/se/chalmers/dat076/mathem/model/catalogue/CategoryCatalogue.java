
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.chalmers.dat076.mathem.model.entityclasses.Category;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *Responsibility: Handles the persistence for the entity class Category
 *Used by: Shop, AddProductCtrl, AddProductBB, ProductsBB
 *Uses: Category
 */

    @Stateless
    public class CategoryCatalogue extends AbstractDAO<Category, String>
            implements ICategoryCatalogue{

        @PersistenceContext
        protected EntityManager eM;

        public CategoryCatalogue() {
            super(Category.class);
        }

        @Override
        public List<Category> getByKey(String id) {
            List<Category> found = new ArrayList<>();
            for (Category c : findRange(0, count())) {
                if (c.getName().equals(id)) {
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

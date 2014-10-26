
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.chalmers.dat076.mathem.model.entityclasses.Recipe;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *Responsibility: Handles the persistence for the entity class Recipe
 *Used by: Shop, RecipeBB
 *Uses: Recipe
 */
@Stateless
public class RecipeCatalogue extends AbstractDAO<Recipe, String>
        implements IRecipeCatalogue {

    @PersistenceContext
    protected EntityManager eM;

    public RecipeCatalogue() {
        super(Recipe.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return eM;
    }

    @Override
    public List<Recipe> getByKey(String name) {
        List<Recipe> found = new ArrayList<>();
        for (Recipe r : findRange(0, count())) {
            if (r.getName().equals(name)) {
                found.add(r);
            }
        }
        return found;
    }

    @Override
    public List<Recipe> getByDescription(String description) {
        List<Recipe> found = new ArrayList<>();
        for (Recipe r : findRange(0, count())) {
            if (r.getDescription().equals(description)) {
                found.add(r);
            }
        }
        return found;
    }
}

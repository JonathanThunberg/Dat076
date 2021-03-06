
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.chalmers.dat076.mathem.model.entityclasses.User;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *Responsibility: Handles the persistence for the entity class Product
 *Used by: Shop, CustomerRegistryCtrl, LoginCtrl, MyPageCtrl, MyPageBB
 *Uses: User
 */
@Stateless
public class UserCatalogue extends AbstractDAO<User, String>
implements IUserCatalogue{
    
    @PersistenceContext
    protected EntityManager eM;
    
    public UserCatalogue() {
        super(User.class);
    }
    
    
    @Override
    public List<User> getByKey(String id) {
        List<User> found = new ArrayList<>();
        for (User u : findRange(0, count())) {
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

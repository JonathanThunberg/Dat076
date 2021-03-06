
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.chalmers.dat076.mathem.model.entityclasses.Adress;
import se.chalmers.dat076.mathem.model.entityclasses.AdressesPK;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *Responsibility: Handles the persistence for the entity class Adress
 *Used by: Shop, CustomerRegistryCtrl, MyPageCtrl
 *Uses: Adress
 */
@Stateless
public class AdressCatalogue extends AbstractDAO <Adress, AdressesPK>
            implements IAdressesCatalogue{
  
    @PersistenceContext
    protected EntityManager eM;

    public AdressCatalogue() {
        super(Adress.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return eM;
    }

    @Override
    public List<Adress> getByKey(AdressesPK k) {
    List<Adress> found = new ArrayList<>();
            for (Adress a : findRange(0, count())) {
                if (a.getAdressesPK().equals(k)) {
                    found.add(a);
                }
            }
            return found;    
    }
    
}

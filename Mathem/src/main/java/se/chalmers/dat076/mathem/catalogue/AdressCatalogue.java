/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.chalmers.dat076.mathem.model.entityclasses.Adress;
import se.chalmers.dat076.mathem.model.entityclasses.AdressesPK;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *
 * @author tuna
 */
public class AdressCatalogue extends AbstractDAO <Adress, AdressesPK>
            implements IAdressCatalogue{
  
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

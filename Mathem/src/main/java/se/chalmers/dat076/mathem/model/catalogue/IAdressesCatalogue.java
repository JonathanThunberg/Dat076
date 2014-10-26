
package se.chalmers.dat076.mathem.model.catalogue;

import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.Adress;
import se.chalmers.dat076.mathem.model.entityclasses.AdressesPK;

@Local
public interface IAdressesCatalogue extends ICatalogue<Adress, AdressesPK>{
    
}

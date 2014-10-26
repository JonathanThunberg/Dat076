
package se.chalmers.dat076.mathem.model.catalogue;

import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.Category;

@Local
public interface ICategoryCatalogue extends ICatalogue <Category, String>{
    
}

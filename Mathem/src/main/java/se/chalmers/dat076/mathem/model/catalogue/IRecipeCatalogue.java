
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.List;
import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.Recipe;

@Local
public interface IRecipeCatalogue extends ICatalogue<Recipe, String> {    
    public List<Recipe> getByDescription(String description);
}

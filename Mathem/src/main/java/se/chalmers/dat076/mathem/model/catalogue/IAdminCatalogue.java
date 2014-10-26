
package se.chalmers.dat076.mathem.model.catalogue;

import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.Admin;


@Local
public interface IAdminCatalogue extends ICatalogue<Admin, String> {
    
}

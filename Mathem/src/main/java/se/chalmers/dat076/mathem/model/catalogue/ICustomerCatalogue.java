
package se.chalmers.dat076.mathem.model.catalogue;

import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;

@Local
public interface ICustomerCatalogue extends ICatalogue <Customer,String> {
    
}

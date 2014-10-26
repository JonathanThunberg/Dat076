
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.List;
import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.CustomerOrder;

@Local
public interface IOrderCatalogue extends ICatalogue<CustomerOrder, Integer> {
    
    public List<CustomerOrder> getByCustomer(String c);
    
}   

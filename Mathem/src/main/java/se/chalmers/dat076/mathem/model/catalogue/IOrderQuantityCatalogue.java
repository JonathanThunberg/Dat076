
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.List;
import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.OrderQuantity;
import se.chalmers.dat076.mathem.model.entityclasses.OrderQuantityPK;

@Local
public interface IOrderQuantityCatalogue extends ICatalogue<OrderQuantity, OrderQuantityPK> {
    public List<OrderQuantity> getByOrder(int order);
}

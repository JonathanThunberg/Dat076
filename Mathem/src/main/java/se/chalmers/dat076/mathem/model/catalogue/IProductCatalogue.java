
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.List;
import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

@Local
public interface IProductCatalogue extends ICatalogue<Product, Integer> {
    public List<Product> getByPrice(double price);
    public List<Product> getByName(String name);
    public List<Product> getByCategory (String category);
}

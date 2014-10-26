
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.chalmers.dat076.mathem.model.entityclasses.Product;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *Responsibility: Handles the persistence for the entity class Product
 *Used by: Shop, AddProductCtrl, EditProductCtrl, ProductDetailBB, ProductsBB
 *  SearchBB
 * Uses: ProductCatalogue
 */
@Stateless
public class ProductCatalogue extends AbstractDAO<Product, Integer>
        implements IProductCatalogue {

    @PersistenceContext
    protected EntityManager eM;

    public ProductCatalogue() {
        super(Product.class);
    }

    @Override
    public List<Product> getByName(String name) {
        List<Product> found = new ArrayList<>();
        for (Product p : findRange(0, count())) {
            if (p.getName().startsWith(name)) {
                found.add(p);
            }
        }
        return found;
    }

    @Override
    public List<Product> getByKey(Integer id) {
        List<Product> found = new ArrayList<>();
        for (Product p : findRange(0, count())) {
            if (p.getId().equals(id)) {
                found.add(p);
            }
        }
        return found;
    }

    @Override
    public List<Product> getByPrice(double price) {
        List<Product> found = new ArrayList<>();
        for (Product p : findRange(0, count())) {
            if (p.getPrice() == (price)) {
                found.add(p);
            }
        }
        return found;
    }

    @Override
    public List<Product> getByCategory(String category) {
        List<Product> found = new ArrayList<>();
        for (Product p : findRange(0, count())) {
            if (p.getCategory().getName().equals(category)) {
                found.add(p);
            }
        }
        return found;
    }

    @Override
    protected EntityManager getEntityManager() {
        return eM;
    }

}

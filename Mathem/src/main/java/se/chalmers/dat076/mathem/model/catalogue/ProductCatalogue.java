/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.chalmers.dat076.mathem.model.entityclasses.Product;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *
 * @author tuna
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
            if (p.getName().equals(name)) {
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

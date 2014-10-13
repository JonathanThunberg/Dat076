/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import se.chalmers.dat076.mathem.model.entityclasses.Products;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *
 * @author tuna
 */
@Stateless
public class ProductCatalogue extends AbstractDAO<Products, Long>
implements ICatalogue  {

    @Inject
    protected EntityManager eM;
    
    public ProductCatalogue() {
        super(Products.class);
    }
 
    
    public List<Products> getByName(String name) {
        List<Products> found = new ArrayList<>();
        for (Products p : findRange(0, count())) {
            if (p.getName().equals(name)) {
                found.add(p);
            }
        }
        return found;
    }
    
    public List<Products> getById(Long id) {
        List<Products> found = new ArrayList<>();
        for (Products p : findRange(0, count())) {
            if (p.getId().equals(id)) {
                found.add(p);
            }
        }
        return found;
    }
    
    public List<Products> getByPrice(double price) {
        List<Products> found = new ArrayList<>();
        for (Products p : findRange(0, count())) {
            if (p.getPrice() == (price)) {
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

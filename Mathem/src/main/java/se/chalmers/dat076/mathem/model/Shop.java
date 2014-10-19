/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.chalmers.dat076.mathem.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

/**
 *
 * @author tuna
 */
@ApplicationScoped 
public class Shop implements Serializable{
    @EJB
    private ProductCatalogue pC;
       
    public ProductCatalogue getProductCatalogue() {
        return pC;
    }
    
    private final List<Product> productList = new ArrayList<>();

    @PostConstruct
    public void post() {        
    }

    public void create(Product p) {
        if (productList.contains(p)) {
            throw new IllegalArgumentException("Product already exists with id " + p.getId());
        }
        productList.add(p);
    }

    public void update(Product p) {
        Product tmp = find(p.getId());
        int i = productList.indexOf(tmp);
        if (i > -1) {
            productList.set(i, p);
        }
    }

    public void delete(Integer id) {
        Product p = find(id);
        if (p != null) {
            productList.remove(p);
        }
    }

    public Product find(Integer id) {
        for (Product p : productList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Collection<Product> findAll() {        
        return productList;
    }

    public Collection<Product> findRange(int first, int n) {
        if (first + n < productList.size()) {
            return productList.subList(first, first + n);
        } else {
            return productList.subList(first, productList.size());
        }
    }

    public int count() {
        return productList.size();
    }
}

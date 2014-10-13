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
import se.chalmers.dat076.mathem.model.entityclasses.Products;

/**
 *
 * @author tuna
 */
@ApplicationScoped 
public class Shop implements Serializable {
    @EJB
    private ProductCatalogue pC;
    
    public ProductCatalogue getProductCatalogue() {
        return pC;
    }
    
    
    /*
    private transient final IShop shop = Shop.newInstance();

    public IShop getShop() {
        return shop;
    }
    */
    
    private final List<Products> productList = new ArrayList<>();

    @PostConstruct
    public void post() {        
    }

    public void create(Products p) {
        if (productList.contains(p)) {
            throw new IllegalArgumentException("Product already exists with id " + p.getId());
        }
        productList.add(p);
    }

    public void update(Products p) {
        Products tmp = find(p.getId());
        int i = productList.indexOf(tmp);
        if (i > -1) {
            productList.set(i, p);
        }
    }

    public void delete(Integer id) {
        Products p = find(id);
        if (p != null) {
            productList.remove(p);
        }
    }

    public Products find(Integer id) {
        for (Products p : productList) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Collection<Products> findAll() {        
        return productList;
    }

    public Collection<Products> findRange(int first, int n) {
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
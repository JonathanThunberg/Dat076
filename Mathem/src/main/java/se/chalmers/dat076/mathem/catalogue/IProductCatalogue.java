/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.catalogue;

import java.util.List;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

/**
 *
 * @author tuna
 */
public interface IProductCatalogue extends ICatalogue<Product, Integer> {
    public List<Product> getByPrice(double price);
    public List<Product> getByName(String name);
    public List<Product> getByCategory (String category);
}

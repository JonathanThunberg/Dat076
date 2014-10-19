/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.chalmers.dat076.mathem.model;

import java.util.List;
import javax.persistence.EntityManager;
import se.chalmers.dat076.mathem.model.entityclasses.Products;
import se.chalmers.dat076.mathem.model.persistance.IDAO;

/**
 *
 * @author tuna 
 */
public interface ICatalogue extends IDAO<Products, Integer> {
    
    public List<Products> getByName(String name);

    public List<Products> getById(Integer id);
            
    public List<Products> getByPrice(double price);
}

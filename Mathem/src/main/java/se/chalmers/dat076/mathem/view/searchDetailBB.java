package se.chalmers.dat076.mathem.view;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author victor_nordh92
 */
@Named
@RequestScoped
public class searchDetailBB implements Serializable{
    
    @Inject
    private Shop shop;
    private List<Product> products = new ArrayList();

    public void setProducts(List<Product> products){
        this.products = products;
    }
            
    public List<Product> getProducts(){
        return products;
    }
            
}

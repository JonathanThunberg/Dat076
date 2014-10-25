/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

/**
 *
 * @author victor_nordh92
 */
@Named
@RequestScoped
public class SearchBB implements Serializable{
    
    private Product prod;
    private String productname;
    
    @Inject 
    private Shop shop;
    
    public void setProductname(String productname){
        System.out.println("Nu sätter vi productname till    :" + productname);
        this.productname = productname;                         
    }
    
    public String getProductname(){
        System.out.println("Nu är vi i productname    :" + productname);
        return productname;   
    }
}

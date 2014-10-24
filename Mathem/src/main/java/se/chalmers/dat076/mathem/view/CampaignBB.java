/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

/**
 *
 * @author victor_nordh92
 */
@ManagedBean
@ViewScoped
public class CampaignBB implements Serializable {

    @Inject
    private Shop shop;
    private List<Product> products;
    private Product selectedProd;
    private int amount = 1;


    public List<Product> getProducts() {        
        return shop.getProductCatalogue().findAll();
    }        
    
    public void setProducts(List<Product> p) {
        products = p;
    }

    public Product getSelectedProd() {
        return selectedProd;
    }

    public void setSelectedProd(Product selectedProd) {
        this.selectedProd = selectedProd;
    }

    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
}

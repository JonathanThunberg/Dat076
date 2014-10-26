/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.OrderItem;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

/**
 *
 * @author victor_nordh92
 */
@Named
@RequestScoped
public class ProductDetailBB implements Serializable{
    
    @Inject
    private Shop shop;
    
    private String productid;
    private List<OrderItem> products = new ArrayList();
    private Product product;
    
    @PostConstruct
    public void init() {
    productid = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("searchitem");
    System.out.println("nu är vi i init productdetail: " + productid);
    }       
    
    public void setProducts(Product product){
        this.product = product;
    }
    
    public List<OrderItem> getProducts() {
        System.out.println("product id = " + productid);
                for (Product p : shop.getProductCatalogue().getByKey(Integer.getInteger(productid))) {
                products.add(new OrderItem(p,1));
            }
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().remove(productid);
            System.out.println("Här är den sökta produkten : " + products);
            return products;
    }   
}

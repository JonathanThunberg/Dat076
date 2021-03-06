package se.chalmers.dat076.mathem.model;

import java.io.Serializable;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

/**
 * Responsibilty: Create orderitems which is a product with a quantity in the shoppingCart
 * Uses: Product, Quantity
 * Used by: BuyConfirmationCtrl, ProductsCtrl, SearchCtrl, ShoppingCartCtrl, 
 *          ShoppingCart, ProductDetailBB, ProductsBB, SearchBB, buyConfirmation.xhtml, 
 *          shoppingCart.xhtml
 */
public class OrderItem implements Serializable{
    
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}

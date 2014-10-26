
package se.chalmers.dat076.mathem.model.entityclasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * Responsibility: specifies a primary key for OrderQuantity
 * Used by: IOrderQuantityCatalogue, OrderQuantityCatalogue, OrderQuantity
 */
@Embeddable
public class OrderQuantityPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCTS")
    private int products;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ORDERID")
    private int orderid;

    public OrderQuantityPK() {
    }

    public OrderQuantityPK(int products, int orderid) {
        this.products = products;
        this.orderid = orderid;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) products;
        hash += (int) orderid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderQuantityPK)) {
            return false;
        }
        OrderQuantityPK other = (OrderQuantityPK) object;
        if (this.products != other.products) {
            return false;
        }
        if (this.orderid != other.orderid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.chalmers.dat076.mathem.model.entityclasses.HasPK[ products=" + products + ", orderid=" + orderid + " ]";
    }
    
}

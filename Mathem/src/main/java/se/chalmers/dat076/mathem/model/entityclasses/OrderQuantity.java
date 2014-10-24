/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model.entityclasses;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tuna
 */
@Entity
@Table(name = "HAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderQuantity.findAll", query = "SELECT h FROM OrderQuantity h"),
    @NamedQuery(name = "OrderQuantity.findByProducts", query = "SELECT h FROM OrderQuantity h WHERE h.hasPK.products = :products"),
    @NamedQuery(name = "OrderQuantity.findByOrderid", query = "SELECT h FROM OrderQuantity h WHERE h.hasPK.orderid = :orderid"),
    @NamedQuery(name = "OrderQuantity.findByAmount", query = "SELECT h FROM OrderQuantity h WHERE h.amount = :amount")})
public class OrderQuantity implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderQuantityPK hasPK;
    @Column(name = "AMOUNT")
    private Integer amount;
    @JoinColumn(name = "PRODUCTS", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CustomerOrder customerOrder;

    public OrderQuantity() {
    }

    public OrderQuantity(OrderQuantityPK hasPK) {
        this.hasPK = hasPK;
    }

    public OrderQuantity(int products, int orderid) {
        this.hasPK = new OrderQuantityPK(products, orderid);
    }

    public OrderQuantityPK getHasPK() {
        return hasPK;   
    }

    public void setHasPK(OrderQuantityPK hasPK) {
        this.hasPK = hasPK;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hasPK != null ? hasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderQuantity)) {
            return false;
        }
        OrderQuantity other = (OrderQuantity) object;
        if ((this.hasPK == null && other.hasPK != null) || (this.hasPK != null && !this.hasPK.equals(other.hasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.chalmers.dat076.mathem.model.entityclasses.Has[ hasPK=" + hasPK + " ]";
    }
    
}


package se.chalmers.dat076.mathem.model.entityclasses;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Responsibility: specifies a customer order
 * Uses: Customer
 * Used by: Shop, BuyConfirmationCtrl, IOrderCatalogue, OrderCatalogue, OrderQuantityCatalogue, 
 * OrderQuantity, OrderHistoryBB
 */
@Entity
@Table(name = "ORDERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerOrders.findAll", query = "SELECT o FROM CustomerOrder o"),
    @NamedQuery(name = "CustomerOrders.findById", query = "SELECT o FROM CustomerOrder o WHERE o.id = :id"),
    @NamedQuery(name = "CustomerOrders.findByDate", query = "SELECT o FROM CustomerOrder o WHERE o.date = :date")})
public class CustomerOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinTable(name = "ISTO", joinColumns = {
    @JoinColumn(name = "ORDERID", referencedColumnName = "ID")}, inverseJoinColumns = {
    @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")})
    @ManyToMany
    private Collection<Customer> customersCollection;

    public Collection<Customer> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customer> customersCollection) {
        this.customersCollection = customersCollection;
    }
    public CustomerOrder() {
    }

    public CustomerOrder(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerOrder)) {
            return false;
        }
        CustomerOrder other = (CustomerOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.chalmers.dat076.mathem.model.entityclasses.Orders[ id=" + id + " ]";
    }
    
}

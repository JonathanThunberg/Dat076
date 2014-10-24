/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model.entityclasses;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Julia
 */
@Entity
@Table(name = "PRODUCTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price")})
public class Product implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<OrderQuantity> hasCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private double price;
    @JoinTable(name = "HAS", joinColumns = {
        @JoinColumn(name = "PRODUCT", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ORDERID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<CustomerOrder> ordersCollection;
    @JoinTable(name = "FAVORITES", joinColumns = {
        @JoinColumn(name = "PRODUCT", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USERNAME", referencedColumnName = "USERNAME")})
    @ManyToMany
    private Collection<Customer> customersCollection;
    @JoinTable(name = "ISIN", joinColumns = {
        @JoinColumn(name = "PRODUCT", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "RECIPE", referencedColumnName = "NAME")})
    @ManyToMany
    private Collection<Recipe> recipesCollection;
    @JoinColumn(name = "CATEGORY", referencedColumnName = "NAME")
    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<CustomerOrder> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<CustomerOrder> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @XmlTransient
    public Collection<Customer> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customer> customersCollection) {
        this.customersCollection = customersCollection;
    }

    @XmlTransient
    public Collection<Recipe> getRecipesCollection() {
        return recipesCollection;
    }

    public void setRecipesCollection(Collection<Recipe> recipesCollection) {
        this.recipesCollection = recipesCollection;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.chalmers.dat076.mathem.model.entityclasses.Products[ id=" + id + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<OrderQuantity> getHasCollection() {
        return hasCollection;
    }

    public void setHasCollection(Collection<OrderQuantity> hasCollection) {
        this.hasCollection = hasCollection;
    }
    
}

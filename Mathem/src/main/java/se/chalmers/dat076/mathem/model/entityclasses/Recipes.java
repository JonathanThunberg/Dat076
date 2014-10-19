/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model.entityclasses;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Julia
 */
@Entity
@Table(name = "RECIPES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipes.findAll", query = "SELECT r FROM Recipes r"),
    @NamedQuery(name = "Recipes.findByName", query = "SELECT r FROM Recipes r WHERE r.name = :name"),
    @NamedQuery(name = "Recipes.findByDescription", query = "SELECT r FROM Recipes r WHERE r.description = :description")})
public class Recipes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "DESCRIPTION")
    private String description;
    @ManyToMany(mappedBy = "recipesCollection")
    private Collection<Products> productsCollection;

    public Recipes() {
    }

    public Recipes(String name) {
        this.name = name;
    }

    public Recipes(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Products> getProductsCollection() {
        return productsCollection;
    }

    public void setProductsCollection(Collection<Products> productsCollection) {
        this.productsCollection = productsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipes)) {
            return false;
        }
        Recipes other = (Recipes) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.chalmers.dat076.mathem.model.entityclasses.Recipes[ name=" + name + " ]";
    }
    
}

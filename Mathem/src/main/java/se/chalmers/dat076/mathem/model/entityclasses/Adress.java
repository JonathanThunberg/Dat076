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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "ADRESSES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Adresses.findAll", query = "SELECT a FROM Adress a"),
    @NamedQuery(name = "Adresses.findByStreetname", query = "SELECT a FROM Adress a WHERE a.adressesPK.streetname = :streetname"),
    @NamedQuery(name = "Adresses.findByCity", query = "SELECT a FROM Adress a WHERE a.adressesPK.city = :city"),
    @NamedQuery(name = "Adresses.findByPostalcode", query = "SELECT a FROM Adress a WHERE a.postalcode = :postalcode")})
public class Adress implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AdressesPK adressesPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "POSTALCODE")
    private String postalcode;
    @OneToMany(mappedBy = "adresses")
    private Collection<Customer> customersCollection;

    public Adress() {
    }

    public Adress(AdressesPK adressesPK) {
        this.adressesPK = adressesPK;
    }

    public Adress(AdressesPK adressesPK, String postalcode) {
        this.adressesPK = adressesPK;
        this.postalcode = postalcode;
    }

    public Adress(String streetname, String city) {
        this.adressesPK = new AdressesPK(streetname, city);
    }

    public AdressesPK getAdressesPK() {
        return adressesPK;
    }

    public void setAdressesPK(AdressesPK adressesPK) {
        this.adressesPK = adressesPK;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @XmlTransient
    public Collection<Customer> getCustomersCollection() {
        return customersCollection;
    }

    public void setCustomersCollection(Collection<Customer> customersCollection) {
        this.customersCollection = customersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adressesPK != null ? adressesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Adress)) {
            return false;
        }
        Adress other = (Adress) object;
        if ((this.adressesPK == null && other.adressesPK != null) || (this.adressesPK != null && !this.adressesPK.equals(other.adressesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.chalmers.dat076.mathem.model.entityclasses.Adresses[ adressesPK=" + adressesPK + " ]";
    }
    
}

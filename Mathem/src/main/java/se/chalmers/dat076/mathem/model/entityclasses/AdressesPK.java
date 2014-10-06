/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model.entityclasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Julia
 */
@Embeddable
public class AdressesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "STREETNAME")
    private String streetname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CITY")
    private String city;

    public AdressesPK() {
    }

    public AdressesPK(String streetname, String city) {
        this.streetname = streetname;
        this.city = city;
    }

    public String getStreetname() {
        return streetname;
    }

    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (streetname != null ? streetname.hashCode() : 0);
        hash += (city != null ? city.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdressesPK)) {
            return false;
        }
        AdressesPK other = (AdressesPK) object;
        if ((this.streetname == null && other.streetname != null) || (this.streetname != null && !this.streetname.equals(other.streetname))) {
            return false;
        }
        if ((this.city == null && other.city != null) || (this.city != null && !this.city.equals(other.city))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.chalmers.dat076.mathem.AdressesPK[ streetname=" + streetname + ", city=" + city + " ]";
    }
    
}

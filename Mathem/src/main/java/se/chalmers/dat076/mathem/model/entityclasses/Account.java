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
@Table(name = "ACCOUNTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accounts.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Accounts.findByCardnumber", query = "SELECT a FROM Account a WHERE a.cardnumber = :cardnumber"),
    @NamedQuery(name = "Accounts.findByName", query = "SELECT a FROM Account a WHERE a.name = :name"),
    @NamedQuery(name = "Accounts.findByExpdate", query = "SELECT a FROM Account a WHERE a.expdate = :expdate"),
    @NamedQuery(name = "Accounts.findByCvc", query = "SELECT a FROM Account a WHERE a.cvc = :cvc")})
public class Account implements Serializable {
    @OneToMany(mappedBy = "account")
    private Collection<Payswith> payswithCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CARDNUMBER")
    private String cardnumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "EXPDATE")
    private String expdate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CVC")
    private String cvc;

    public Account() {
    }

    public Account(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public Account(String cardnumber, String name, String expdate, String cvc) {
        this.cardnumber = cardnumber;
        this.name = name;
        this.expdate = expdate;
        this.cvc = cvc;
    }

    public String getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpdate() {
        return expdate;
    }

    public void setExpdate(String expdate) {
        this.expdate = expdate;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cardnumber != null ? cardnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.cardnumber == null && other.cardnumber != null) || (this.cardnumber != null && !this.cardnumber.equals(other.cardnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.chalmers.dat076.mathem.model.entityclasses.Accounts[ cardnumber=" + cardnumber + " ]";
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Payswith> getPayswithCollection() {
        return payswithCollection;
    }

    public void setPayswithCollection(Collection<Payswith> payswithCollection) {
        this.payswithCollection = payswithCollection;
    }
    
}

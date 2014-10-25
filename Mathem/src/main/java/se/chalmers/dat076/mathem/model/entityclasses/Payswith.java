/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model.entityclasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tuna
 */
@Entity
@Table(name = "PAYSWITH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payswith.findAll", query = "SELECT p FROM Payswith p"),
    @NamedQuery(name = "Payswith.findByCustomer", query = "SELECT p FROM Payswith p WHERE p.customer = :customer")})
public class Payswith implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CUSTOMER")
    private String customer;
    @JoinColumn(name = "CUSTOMER", referencedColumnName = "USERNAME", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Customer customer1;
    @JoinColumn(name = "ACCOUNT", referencedColumnName = "CARDNUMBER")
    @ManyToOne
    private Account account;

    public Payswith() {
    }

    public Payswith(String customer) {
        this.customer = customer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Customer getCustomer1() {
        return customer1;
    }

    public void setCustomer1(Customer customer1) {
        this.customer1 = customer1;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customer != null ? customer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payswith)) {
            return false;
        }
        Payswith other = (Payswith) object;
        if ((this.customer == null && other.customer != null) || (this.customer != null && !this.customer.equals(other.customer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "se.chalmers.dat076.mathem.model.entityclasses.Payswith[ customer=" + customer + " ]";
    }
    
}

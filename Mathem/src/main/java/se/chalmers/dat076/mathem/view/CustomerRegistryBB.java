/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;
 
import javax.faces.bean.ManagedBean;
import se.chalmers.dat076.mathem.model.entityclasses.Adresses;
import se.chalmers.dat076.mathem.model.entityclasses.Customers;
import se.chalmers.dat076.mathem.model.entityclasses.Users;

/**
 *
 * @author victor_nordh92
 */
@ManagedBean
public class CustomerRegistryBB {
   
    private Customers customer;
    private Users user;
    
    private String name = customer.getName();
    private Integer phone = customer.getPhone();
    private String email = customer.getEmail();
    private Adresses adress = customer.getAdresses();
    private String password = user.getPassword();
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getPhone() {
        return phone;
    }
    
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
        
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Adresses getAdress() {
        return adress;
    }
        
    public void setEmail(Adresses adress) {
        this.adress = adress;
    }
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
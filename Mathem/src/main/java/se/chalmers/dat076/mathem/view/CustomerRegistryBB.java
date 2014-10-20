/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;
 
import javax.faces.bean.ManagedBean;
import se.chalmers.dat076.mathem.model.entityclasses.Adress;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
import se.chalmers.dat076.mathem.model.entityclasses.User;

/**
 *
 * @author victor_nordh92
 */
@ManagedBean
public class CustomerRegistryBB {
   
    private Customer customer;
    private User user;
    
    private String name = customer.getName();
    private Integer phone = customer.getPhone();
    private String email = customer.getEmail();
    private Adress adress = customer.getAdresses();
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
    
    public Adress getAdress() {
        return adress;
    }
        
    public void setEmail(Adress adress) {
        this.adress = adress;
    }
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
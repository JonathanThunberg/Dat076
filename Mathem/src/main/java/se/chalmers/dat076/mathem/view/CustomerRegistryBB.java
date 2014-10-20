/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;
 
import javax.faces.bean.ManagedBean;
<<<<<<< HEAD
import se.chalmers.dat076.mathem.model.entityclasses.Adresses;
import se.chalmers.dat076.mathem.model.entityclasses.Customers;
import se.chalmers.dat076.mathem.model.entityclasses.Users;

=======
import se.chalmers.dat076.mathem.model.entityclasses.Adress;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
>>>>>>> 99b338b0c8cf47a3fa2ad9d1e140464a86ff5698
/**
 *
 * @author victor_nordh92
 */
@ManagedBean
public class CustomerRegistryBB {
   
<<<<<<< HEAD
    private Customers customer;
    private Users user;
    
    private String name = customer.getName();
    private Integer phone = customer.getPhone();
    private String email = customer.getEmail();
    private Adresses adress = customer.getAdresses();
    private String password = user.getPassword();
    
=======
    private Customer customer;
    private String name = customer.getName();
    private Integer phone = customer.getPhone();
    private String email = customer.getEmail();
    private Adress adress = customer.getAdresses();
 
>>>>>>> 99b338b0c8cf47a3fa2ad9d1e140464a86ff5698
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
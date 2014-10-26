package se.chalmers.dat076.mathem.view;
 
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *Responsibility: Keeps some data for CustomerRegistry.xhtlm and CustomerRegistryCtrl 
 *Used by: CustomerRegistry.xhtlm, CustomerRegistryCtrl 
 */
@Named
@RequestScoped
public class CustomerRegistryBB implements Serializable{    
    
    private String name; 
    private String username;
    private String password;
    private Integer phone;
    private String email;
    
    private String streetname;
    private String city;
    private String postcode;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
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
    
    public String getStreetname() {
        return streetname;
    }
        
    public void setStreetname(String streetname) {
        this.streetname = streetname;
    }
    
    public String getPostcode() {
        return postcode;

    }
        
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    public String getCity() {
        return city;
    }
        
    public void setCity(String city) {
        this.city = city;
    }
}


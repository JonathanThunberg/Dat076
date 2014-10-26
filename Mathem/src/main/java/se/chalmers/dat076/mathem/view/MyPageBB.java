
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;

/**
 *Responsibility: Keeps some data for MyPage.xhtlm and MyPageCtrl 
 *Used by: MyPageBBxhtlm, MyPageCtrl
 *Uses: shop, UserCatalogue, CustomerCatalogue
 */
@Named
@RequestScoped
public class MyPageBB implements Serializable{
    
    @Inject
    private Shop shop;
    
    private Customer customer;
    private String name;
    private String username;
    private String password;
    private Integer phone;
    private String email;
    
    private String streetname;
    private String city;
    private String postcode;
    private String newPassword;
    
    
    @PostConstruct
    public void init() {
        customer = shop.getCustomerCatalogue().getByKey(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user").toString()).get(0);
        name = customer.getName();
        username = customer.getUsername();
        password = shop.getUserCatalogue().getByKey(username).get(0).getPassword();
        phone = customer.getPhone();
        email = customer.getEmail();
        streetname = customer.getAdresses().getAdressesPK().getStreetname();
        city = customer.getAdresses().getAdressesPK().getCity();
        postcode = customer.getAdresses().getPostalcode();
        newPassword = "";
    }
    
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
    
    public String getNewPassword() {
        return newPassword;
    }
    
    public void setNewPassword(String password) {
        newPassword = password;
    }
}


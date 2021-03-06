
package se.chalmers.dat076.mathem.ctrl;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Adress;
import se.chalmers.dat076.mathem.model.entityclasses.AdressesPK;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
import se.chalmers.dat076.mathem.model.entityclasses.User;
import se.chalmers.dat076.mathem.util.PasswordUtil;
import se.chalmers.dat076.mathem.view.MyPageBB;

/**
 * Responsibility: Change a customers contact information
 * Uses: Shop, MyPageBB, User, Customer, Adress
 * Used by: myPage.xhtml
 */

@Named
@RequestScoped
public class MyPageCtrl {
    private MyPageBB regBB;
    
    @Inject
    private Shop shop;
    
    @Inject
    public void setMyPageBB(MyPageBB regBB) {
        this.regBB = regBB;
    }
    
    public void submit() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        if(PasswordUtil.PasswordToHash(regBB.getPassword()).equals(shop.getUserCatalogue().getByKey(regBB.getUsername()).get(0).getPassword())){
            Customer customer = new Customer(regBB.getUsername());
            boolean adressChanged = !shop.getCustomerCatalogue().getByKey(regBB.getUsername()).get(0).getAdresses().getAdressesPK().equals(new AdressesPK(regBB.getStreetname(),regBB.getCity()));
            boolean passwordChanged = !regBB.getNewPassword().equals("");
            if(passwordChanged){
                User user = new User(regBB.getUsername());
                user.setPassword(PasswordUtil.PasswordToHash(regBB.getNewPassword()));
                shop.getCustomerCatalogue().delete(customer.getUsername());
                shop.getUserCatalogue().delete(user.getUsername());
                shop.getUserCatalogue().create(user);
                customer.setUsers(user);
            }
            
            if(adressChanged) {
                if(shop.getAdressCatalogue().getByKey(new AdressesPK(regBB.getStreetname(), regBB.getCity())).isEmpty()) {
                    Adress adress = new Adress(regBB.getStreetname(), regBB.getCity());
                    adress.setPostalcode(regBB.getPostcode());
                    
                    if(!passwordChanged) {
                        shop.getCustomerCatalogue().delete(customer.getUsername());
                    }
                    shop.getAdressCatalogue().delete(new AdressesPK(regBB.getStreetname(), regBB.getCity()));
                    shop.getAdressCatalogue().create(adress);
                    customer.setAdresses(adress);
                    updateCustomer(customer);
                    
                }else{
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Adress upptagen", ""));
                    context.getExternalContext().getFlash().setKeepMessages(true);
                }
                
            }else{
                
                Adress adress = new Adress(new AdressesPK(regBB.getStreetname(),regBB.getCity()));
                adress.setPostalcode(regBB.getPostcode());
                
                shop.getCustomerCatalogue().delete(customer.getUsername());
                shop.getAdressCatalogue().delete(new AdressesPK(regBB.getStreetname(), regBB.getCity()));
                shop.getAdressCatalogue().create(adress);
                customer.setAdresses(adress);
                updateCustomer(customer);
            }
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Fel lösenord", ""));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }
        
        //Feedback
    }
    
    private void updateCustomer(Customer customer) throws IOException {
        
        customer.setName(regBB.getName());
        customer.setPhone(regBB.getPhone());
        customer.setEmail(regBB.getEmail());
        shop.getCustomerCatalogue().create(customer);
        FacesContext.getCurrentInstance().getExternalContext().redirect("products.xhtml");
    }
    
}

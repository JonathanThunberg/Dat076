package se.chalmers.dat076.mathem.ctrl;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.catalogue.ICatalogue;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.User;
import se.chalmers.dat076.mathem.util.PasswordUtil;
import se.chalmers.dat076.mathem.view.LoginBB;

/**
 *
 * @author Julia
 */
@Named
@RequestScoped
public class LoginCtrl implements Serializable {
    
    @Inject
    private Shop shop;
    
    private final Logger LOG = Logger.getAnonymousLogger();
    
    private LoginBB loginBB;
    
    @Inject
    public void setLoginBB(LoginBB loginBB) {
        this.loginBB = loginBB;
    }
    
    
    public void login() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        
        
        ICatalogue uc = shop.getUserCatalogue();
        if(uc.getByKey(loginBB.getUser()).isEmpty()) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Användaren finns ej", ""));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }else if(!((User)(uc.getByKey(loginBB.getUser()).get(0))).getPassword().equals(PasswordUtil.PasswordToHash(loginBB.getPassword()))) {
            
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Fel lösenord", ""));
            context.getExternalContext().getFlash().setKeepMessages(true);
        }else{
            context.getExternalContext().getSessionMap().put("user", loginBB.getUser());
            context.getExternalContext().redirect("products.xhtml");
            
            
        }
        
        
    }
    
    public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("products.xhtml");
        
    }
    
    
    
}

package se.chalmers.dat076.mathem.ctrl;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.ICatalogue;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.User;
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
    
    
    private LoginBB loginBB;
    
    @Inject
    public void setLoginBB(LoginBB loginBB) {
        this.loginBB = loginBB;
    }
    
    @PostConstruct
    public void post() {
        ;
    }
    
    public void login() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        ICatalogue uc = shop.getUserCatalogue();
        if(!uc.getByKey(loginBB.getUser()).isEmpty()) {
            if(((User)(uc.getByKey(loginBB.getUser()).get(0))).getPassword().equals(loginBB.getPassword())){
                context.getExternalContext().getSessionMap().put("user", loginBB.getUser());
            }else{
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fel lösenord", null));
            }
        }else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Användaren finns ej", null));
        }
        
    }
    
    public void logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
    
    
}


package se.chalmers.dat076.mathem.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *Responsibility: Keeps some data for Login.xhtlm and LoginCtrl 
 *Used by: Login.xhtlm, LoginCtrl
 */
@Named
@RequestScoped
public class LoginBB {
    
    private String user;
    private String password;
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    
}

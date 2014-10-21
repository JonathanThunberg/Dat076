/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package se.chalmers.dat076.mathem.view;

import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Julia
 */
@ManagedBean
public class LoginDialog {
    
    public void login() {
        
        RequestContext.getCurrentInstance().openDialog("login.xhtml");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Julia
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

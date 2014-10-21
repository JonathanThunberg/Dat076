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
 * @author victor_nordh92
 */
@ManagedBean
public class CustomRegistryDialog {
       
    public void openRegistry() {
        
        RequestContext.getCurrentInstance().openDialog("contact.xhtml");
    }

}


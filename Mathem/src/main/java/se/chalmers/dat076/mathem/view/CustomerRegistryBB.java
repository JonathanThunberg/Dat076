/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;
 
import javax.faces.bean.ManagedBean;
/**
 *
 * @author victor_nordh92
 */
@ManagedBean
public class CustomerRegistryBB {
   
    private String text;
 
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
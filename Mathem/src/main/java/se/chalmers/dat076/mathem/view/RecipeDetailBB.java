/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author victor_nordh92
 */
@Named
@RequestScoped
public class RecipeDetailBB implements Serializable{
    
    
    private String name;
    private String description;    
    
    public String getName() {
        System.out.println("Nu är vi fel1");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Nu har vi satt namn: " + name);
    }

    public String getDescription() {
        System.out.println("Nu är vi fel2");
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        System.out.println("Nu har vi satt description: " + description);
    }

}

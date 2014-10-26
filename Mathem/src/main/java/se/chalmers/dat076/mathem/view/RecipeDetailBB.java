
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *Responsibility: Keeps some data for RecipeDetail.xhtlm
 *Used by: Recipe.htlm
 *Uses: Shop
 */
@Named
@RequestScoped
public class RecipeDetailBB implements Serializable{
    
    
    private String name;
    private String description;    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

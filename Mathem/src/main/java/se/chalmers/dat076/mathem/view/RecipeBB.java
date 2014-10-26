package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Recipe;

/**
 *Responsibility: Keeps some data for Recipe.xhtlm
 *Used by: Recipe.htlm, RecipeCtrl
 *Uses: shop, Recipe, RecipeCatalogue
 */
@Named
@RequestScoped
public class RecipeBB implements Serializable {

    @Inject
    private Shop shop;

    private List<Recipe> recipes;
    private Recipe selectedrecp;    

    @PostConstruct
    public void init() {
        this.recipes = this.shop.getRecipeCatalogue().findAll();
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public Recipe getSelectedRecp() {
        return selectedrecp;
    }

    public void setSelectedRecp(Recipe selectedrecp){          
        this.selectedrecp = selectedrecp;               
    }   

}

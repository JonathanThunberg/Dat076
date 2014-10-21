/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.view;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import se.chalmers.dat076.mathem.model.Shop;
import se.chalmers.dat076.mathem.model.entityclasses.Recipe;

/**
 *
 * @author victor_nordh92
 */
@ManagedBean
@ViewScoped
public class RecipeBB implements Serializable {

    @Inject
    private Shop shop;

    private static final Logger LOG = Logger.getLogger(ProductsBB.class.getName());

    private List<Recipe> recipes;
    private Recipe selectedrecp;

    @PostConstruct
    public void init() {
        System.out.println("Nu är VI HÄÄÄÄÄÄÄÄÄR");
        this.recipes = this.shop.getRecipeCatalogue().findAll();
        System.out.println("Nu är VI KLAAAAAAARA");
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public Recipe getSelectedRecp() {
        return selectedrecp;
    }

    public void setSelectedRecp(Recipe selectedrecp) {
        this.selectedrecp = selectedrecp;
    }
}

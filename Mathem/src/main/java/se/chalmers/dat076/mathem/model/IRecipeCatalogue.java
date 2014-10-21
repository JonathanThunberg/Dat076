/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model;

import java.util.List;
import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.Recipe;

/**
 *
 * @author victor_nordh92
 */
@Local
public interface IRecipeCatalogue extends ICatalogue<Recipe, String> {    
    public List<Recipe> getByDescription(String description);
}

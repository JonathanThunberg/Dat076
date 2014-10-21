/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model;

import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.Adress;
import se.chalmers.dat076.mathem.model.entityclasses.AdressesPK;

/**
 *
 * @author Julia
 */
@Local
public interface IAdressesCatalogue extends ICatalogue<Adress, AdressesPK>{
    
}

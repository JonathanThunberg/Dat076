/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model.catalogue;

import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.Admin;

/**
 *
 * @author tuna
 */
@Local
public interface IAdminCatalogue extends ICatalogue<Admin, String> {
    
}

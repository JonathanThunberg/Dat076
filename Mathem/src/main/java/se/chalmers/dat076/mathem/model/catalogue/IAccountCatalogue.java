/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model.catalogue;

import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.Account;

/**
 *
 * @author tuna
 */
@Local
public interface IAccountCatalogue extends ICatalogue<Account, String>{    
}

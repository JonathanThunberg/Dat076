/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model;

import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;

/**
 *
 * @author victor_nordh92
 */
@Local
public interface ICustomerCatalogue extends ICatalogue <Customer,String> {
    
}

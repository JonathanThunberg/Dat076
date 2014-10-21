/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.chalmers.dat076.mathem.model.catalogue;

import java.util.List;
import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.persistance.IDAO;

/**
 *
 * @author tuna 
 */
@Local
public interface ICatalogue<T, K> extends IDAO<T, K> {
    
    public List<T> getByKey(K k);
}

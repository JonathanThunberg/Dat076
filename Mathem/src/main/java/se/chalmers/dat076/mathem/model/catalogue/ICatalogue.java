

package se.chalmers.dat076.mathem.model.catalogue;

import java.util.List;
import javax.ejb.Local;
import se.chalmers.dat076.mathem.model.persistance.IDAO;

@Local
public interface ICatalogue<T, K> extends IDAO<T, K> {
    
    public List<T> getByKey(K k);
}

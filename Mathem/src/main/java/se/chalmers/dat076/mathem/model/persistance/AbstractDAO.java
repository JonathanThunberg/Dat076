package se.chalmers.dat076.mathem.model.persistance;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public abstract class AbstractDAO<T, K> {

    // Emulate a database
    private final Class<T> clazz;
  
    protected abstract EntityManager getEntityManager();
            
    
    public AbstractDAO(Class<T> clazz){
    this.clazz=clazz;    
    }
    
    public void create(T t) {
        getEntityManager().persist(t);
    }

    public void delete(K id) {
        T t = getEntityManager().getReference(clazz, id);
        getEntityManager().remove(t);
    }

    public void update(T t) {
        getEntityManager().merge(t);
    }

    public T find(K id) {
        return getEntityManager().find(clazz, id);
    }

    public List<T> findAll() {
        return get(true, -1, -1);
    }

    public List<T> findRange(int first, int n) {
        return get(false, first, n);
    }

    private List<T> get(boolean all, int first, int n) {
        EntityManager em = getEntityManager();
        List<T> found = new ArrayList<>();
        TypedQuery<T> q = em.createQuery("select t from " + clazz.getSimpleName() + " t", clazz);
        if (!all) {
            q.setFirstResult(first);
            q.setMaxResults(n);
        }
        found.addAll(q.getResultList());
        return found;
    }

    public int count() {
        EntityManager em = getEntityManager();
        Long n = em.createQuery("select count(t) from " + clazz.getSimpleName() + " t", Long.class)
                .getSingleResult();
        return n.intValue();
    }
}

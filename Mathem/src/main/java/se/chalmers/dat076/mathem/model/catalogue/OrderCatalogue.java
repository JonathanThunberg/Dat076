/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.dat076.mathem.model.catalogue;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import se.chalmers.dat076.mathem.model.entityclasses.Customer;
import se.chalmers.dat076.mathem.model.entityclasses.CustomerOrder;
import se.chalmers.dat076.mathem.model.entityclasses.User;
import se.chalmers.dat076.mathem.model.persistance.AbstractDAO;

/**
 *
 * @author tuna
 */
@Stateless
public class OrderCatalogue extends AbstractDAO<CustomerOrder, Integer>
        implements IOrderCatalogue {

    @PersistenceContext
    protected EntityManager eM;

    public OrderCatalogue() {
        super(CustomerOrder.class);
    }

    @Override
    public List<CustomerOrder> getByKey(Integer id) {
        List<CustomerOrder> found = new ArrayList<>();
        for (CustomerOrder o : findRange(0, count())) {
            if (o.getId().equals(id)) {
                found.add(o);
            }
        }
        return found;
    }

    @Override
    public List<CustomerOrder> getByCustomer(String c) {
        List<CustomerOrder> found = new ArrayList<>();
        for (CustomerOrder o : findRange(0, count())) {
            for (Customer a : o.getCustomersCollection()) {
                if (a.getUsername().equals(c)) {
                    found.add(o);
                }
            }
        }
        return found;
    }

    @Override
    protected EntityManager getEntityManager() {
        return eM;
    }

}

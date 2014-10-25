/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package se.chalmers.dat076.mathem.model;

import java.util.List;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import se.chalmers.dat076.mathem.model.entityclasses.Product;

/**
 *
 * @author tuna
 */

@RunWith(Arquillian.class)
public class ProductCatalogueTest {
    
    
    @Inject
            Shop shop;
    
    @Inject
            UserTransaction utx;
    
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                // Add all classes
                .addPackage("se.chalmers.dat076.mathem.model")
                // This will add test-persitence.xml as persistence.xml (renamed)
                // in folder META-INF, see Files > jpa_managing > target > arquillian
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                // Must have for CDI to work
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        
    }
    
    @Before  // Run before each test
    public void before() throws Exception {
        clearAll();
    }
    
    @PersistenceContext
    @Produces
    @Default
    EntityManager em;
    
    // Order matters
    private void clearAll() throws Exception {
        utx.begin();
        em.joinTransaction();
        em.createQuery("delete from Product").executeUpdate();
        utx.commit();
    }
    
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Product t = new Product(1,"aaa", 8.1);
        shop.getProductCatalogue().create(t);
        List<Product> ps = shop.getProductCatalogue().findAll();
        assertTrue(ps.size() > 0);
        assertTrue(ps.get(0).getName().equals(t.getName()));
        
    }
}

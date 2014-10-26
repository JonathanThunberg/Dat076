/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package se.chalmers.dat076.mathem.model;

import java.util.List;
import java.util.Locale.Category;
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
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import se.chalmers.dat076.mathem.model.entityclasses.Product;
import se.chalmers.dat076.mathem.model.entityclasses.Recipe;
*/

/**
 *
 * @author tuna
 */

/*
@RunWith(Arquillian.class)
public class CatalogueTest {

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

    @Test
    public void testCreate() throws Exception {
        Product t = new Product(1, "aaa", 8.1);
        shop.getProductCatalogue().create(t);
        List<Product> ps = shop.getProductCatalogue().findAll();
        assertTrue(ps.size() > 0);
        assertTrue(ps.get(0).getName().equals(t.getName()));
    }

    @Test
    public void testDelete() throws Exception {
        Product t = new Product(1, "aaa", 8.1);
        shop.getProductCatalogue().create(t);
        shop.getProductCatalogue().delete(t.getId());
        List<Product> ps = shop.getProductCatalogue().findAll();
        assertTrue(ps.size() > 0);
        assertTrue(ps.get(0).getName().equals(t.getName()));
    }

    @Test
    public void testUpdate() throws Exception {

        Product p = new Product(1, "aaa", 999);
        shop.getProductCatalogue().create(p);
        Integer tmpid = p.getId();

        Product p2 = new Product(tmpid, "ge", 123);

        shop.getProductCatalogue().update(p2);
        Product ps = shop.getProductCatalogue().find(p2.getId());

        assertTrue(ps.getId().equals(p2.getId()));
        assertTrue(ps.getName().equals(p2.getName()));
        assertTrue(ps.getPrice() == p2.getPrice());
    }

    @Test
    public void testFind() throws Exception {

        Product p = new Product(1, "aaa", 999);
        shop.getProductCatalogue().create(p);
        Product ps = shop.getProductCatalogue().find(p.getId());
        assertTrue(ps.equals(p));
    }

    @Test
    public void testName() throws Exception {

        Product p1 = new Product(1, "aaa", 999);
        Product p2 = new Product(2, "bbb", 999);
        Product p3 = new Product(3, "ccc", 999);
        shop.getProductCatalogue().create(p1);
        shop.getProductCatalogue().create(p2);
        shop.getProductCatalogue().create(p3);
        List<Product> list = shop.getProductCatalogue().getByName("aaa");
        assertTrue(list.size() == 1);
    }

    @Test
    public void testPrice() throws Exception {

        Product p1 = new Product(1, "aaa", 999);
        Product p2 = new Product(2, "bbb", 111);
        Product p3 = new Product(3, "ccc", 222);
        shop.getProductCatalogue().create(p1);
        shop.getProductCatalogue().create(p2);
        shop.getProductCatalogue().create(p3);
        List<Product> list = shop.getProductCatalogue().getByPrice(999);
        assertTrue(list.size() == 1);
    }

    // Order matters
    private void clearAll() throws Exception {
        utx.begin();
        em.joinTransaction();
        em.createQuery("delete from Product").executeUpdate();
        utx.commit();
    }

    @Test
    public void testCategory() throws Exception {

        Product p1 = new Product(1, "aaa", 999);
        Product p2 = new Product(2, "bbb", 999);
        Product p3 = new Product(3, "ccc", 999);
        p1.setCategory("Dryck");
        p2.setCategory("Dryck");
        p3.setCategory("Godis");
        shop.getProductCatalogue().create(p1);
        shop.getProductCatalogue().create(p2);
        shop.getProductCatalogue().create(p3);

        List<Product> list = shop.getProductCatalouge().getByCategory("Godis");
        assertTrue(list.size() == 1);
    }
    
    @Test
    public void testKey () throws Exception {
        Product p1 = new Product(1, "aaa", 999);
        Product p2 = new Product(2, "bbb", 999);
        Product p3 = new Product(3, "ccc", 999);
        shop.getProductCatalogue().create(p1);
        shop.getProductCatalogue().create(p2);
        shop.getProductCatalogue().create(p3);

        List<Product> list = shop.getProductCatalouge().getByKey(2);
        assertTrue(list.size() == 1);
    }
         
    @Test
    public void testDescription () throws Exception {
        
        Recipe r1 = new Recipe("aa","descr1");
        Recipe r2 = new Recipe("bb","descr2");
        Recipe r3 = new Recipe("cc","descr3");
        shop.getRecipeCatalogue().create(r1);
        shop.getRecipeCatalogue().create(r2);
        shop.getRecipeCatalogue().create(r3);
        
        List<Recipe> list = shop.getRecipeCatalogue().getByDescription("descr2");
        assertTrue(list.size() == 1);
    }
    
}
*/
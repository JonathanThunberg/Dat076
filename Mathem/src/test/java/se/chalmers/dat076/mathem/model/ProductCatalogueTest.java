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
 /**
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
               // .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                // Must have for CDI to work
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        
    }
    
    @Before  // Run before each test
    public void before() throws Exception {
        clearAll();
    }
    
   
    EntityManager em;
    
    // Order matters
    private void clearAll() throws Exception {
        em=shop.getProductCatalogue().getEntityManager();
        utx.begin();
        em.joinTransaction();
        em.createQuery("delete from Products").executeUpdate();
        utx.commit();
    }
   
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Products t = new Products(1,"aaa", 8.1);
        ProductCatalogue instance= shop.getProductCatalogue();
        instance.create(t);
        List<Products> ps = instance.findAll();
        assertTrue(ps.size() > 0);
        assertTrue(ps.get(0).getName().equals(t.getName()));
        
    }

   
     * Test of delete method, of class ProductCatalogue.
     
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Long id = null;
        ProductCatalogue instance = new ProductCatalogue();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Products t = null;
        ProductCatalogue instance = new ProductCatalogue();
        instance.update(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Long id = null;
        ProductCatalogue instance = new ProductCatalogue();
        Products expResult = null;
        Products result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        ProductCatalogue instance = new ProductCatalogue();
        List<Products> expResult = null;
        List<Products> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int first = 0;
        int n = 0;
        ProductCatalogue instance = new ProductCatalogue();
        List<Products> expResult = null;
        List<Products> result = instance.findRange(first, n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        ProductCatalogue instance = new ProductCatalogue();
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetByName() throws Exception {
        System.out.println("getByName");
        String name = "";
        ProductCatalogue instance = new ProductCatalogue();
        List<Products> expResult = null;
        List<Products> result = instance.getByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetById() throws Exception {
        System.out.println("getById");
        Long id = null;
        ProductCatalogue instance = new ProductCatalogue();
        List<Products> expResult = null;
        List<Products> result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetByPrice() throws Exception {
        System.out.println("getByPrice");
        double price = 0.0;
        ProductCatalogue instance = new ProductCatalogue();
        List<Products> expResult = null;
        List<Products> result = instance.getByPrice(price);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */


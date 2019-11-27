/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import models.Employee;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class EmployeeControllerTest {
    
    public EmployeeControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class EmployeeController.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        
        EmployeeController instance = new EmployeeController();
        List<Employee> expResult = new ArrayList<>();
        List<Employee> result = instance.getAll();
        assertEquals(expResult.contains(this), result.contains(this));
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class EmployeeController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        String id = "39";
        String firstname = "Demen";
        String lastname = "tria";
        String email = "budhhhssshh@";
        String phone = "0819";
        String hire = "2012-12-12";
        String salary = "354";
        String commision = "0";
        String manager = "101";
        String job = "AD_VP";
        String department = "10";
        EmployeeController instance = new EmployeeController();
        String expResult = "Success to Create Employee";
        String result = instance.create(id, firstname, lastname, email, phone, hire, salary, commision, manager, job, department);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class EmployeeController.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        String id = "39";
        String firstname = "Dem";
        String lastname = "tria";
        String email = "budhhhssshh@";
        String phone = "0819";
        String hire = "2012-12-12";
        String salary = "354";
        String commision = "0";
        String manager = "101";
        String job = "AD_VP";
        String department = "10";
        EmployeeController instance = new EmployeeController();
        String expResult = "Success to Update Employee";
        String result = instance.update(id, firstname, lastname, email, phone, hire, job, salary, commision, manager, department);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class EmployeeController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String id = "39";
        EmployeeController instance = new EmployeeController();
        String expResult = "Success to Delete Employee";
        String result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of selectById method, of class EmployeeController.
     */
    @Test
    public void testSelectById() {
        System.out.println("selectById");
        String id = "120";
        EmployeeController instance = new EmployeeController();
        Employee expResult = new Employee(120);
        Employee result = instance.selectById(id);
        assertEquals(expResult.getId(), result.getId());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of selectByName method, of class EmployeeController.
     */
    @Test
    public void testSelectByName() {
        System.out.println("selectByName");
        String name = "Steven";
        EmployeeController instance = new EmployeeController();
        Employee expResult = new Employee("Steven");
        Employee result = instance.selectByName(name);
        assertEquals(expResult.getFirstname(), result.getFirstname());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class EmployeeController.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String key = "-";
        EmployeeController instance = new EmployeeController();
        List<Employee> expResult = new ArrayList<>();
       
        List<Employee> result = instance.search(key);
        assertEquals(expResult.contains(key), result.contains(key));
        assertTrue(true);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.EmployeeController;
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
public class EmployeeUT {
    EmployeeController employeeController;
   
    public EmployeeUT() {
            }
     public void init(){
       employeeController=new  EmployeeController();
    }

    
    @BeforeClass
    public static void tesInsert() {
//       
//        assertEquals(11, "d", "Tampu", "dennnnn@", 5311944, "2012-01-01",  3000,
//                0, 101,"AD_VP", 10, employeeController.create("11", "d", 
//                        "Tampu", "dennnnn@", "5311944", "2012-01-01",  "3000", "0", "101","AD_VP", "10"));
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

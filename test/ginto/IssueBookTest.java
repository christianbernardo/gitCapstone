/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ginto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Camillebernardo
 */
public class IssueBookTest {
    
    public IssueBookTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of Connect method, of class IssueBook.
     */
    @Test
    public void testConnect() {
        System.out.println("Connect");
        IssueBook instance = new IssueBook();
        instance.Connect();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class IssueBook.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        IssueBook.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of $$anonymousClasses method, of class IssueBook.
     */
    @Test
    public void test$$anonymousClasses() {
        System.out.println("$$anonymousClasses");
        IssueBook instance = new IssueBook();
        instance.$$anonymousClasses();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

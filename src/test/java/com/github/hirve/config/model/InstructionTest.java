/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.model;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 1
 */
public class InstructionTest {
  
  /**
   *
   */
  public InstructionTest() {
  }
  
  /**
   *
   */
  @BeforeClass
  public static void setUpClass() {
  }
  
  /**
   *
   */
  @AfterClass
  public static void tearDownClass() {
  }
  
  /**
   *
   */
  @Before
  public void setUp() {
  }
  
  /**
   *
   */
  @After
  public void tearDown() {
  }

  /**
   * Test of getKeyword method, of class Instruction.
   */
  @Test
  public void testGetKeyword() {
    System.out.println("getKeyword");
    Instruction instance = new Instruction("  aaa a(1) b() c( ') d(1000)=e");
    String expResult = "aaa";
    String result = instance.getKeyword();
    assertEquals(expResult, result);
  }

  /**  = 
   * Test of setKeyword method, of class Instruction.
   */
  @Test
  public void testSetKeyword() {
    System.out.println("setKeyword");
    Instruction instance = new Instruction("  aaa a(1) b() c( ') d(1000)=e");
    instance.setKeyword("bbb");
    String expResult = "bbb";
    String result = instance.getKeyword();
    assertEquals(expResult, result);
  }

  /**
   * Test of getOptions method, of class Instruction.
   */
  @Test
  public void testGetOptions() {
    System.out.println("getOptions");
    Instruction instance = new Instruction("  aaa a(1) b() c( ') d(1000) = e");
    
    int expCount = 4;
    int count = instance.getOptions().size();
    assertEquals(expCount, count);
    
    String expResult;
    String result;
    
    expResult = "a(1)";
    result = instance.getOptions().get("a").toString();
    assertEquals(expResult, result);
    
    expResult = "b()";
    result = instance.getOptions().get("b").toString();
    assertEquals(expResult, result);
    
    expResult = "c( ')";
    result = instance.getOptions().get("c").toString();
    assertEquals(expResult, result);
    
    expResult = "d(1000) = e";
    result = instance.getOptions().get("d").toString();
    assertEquals(expResult, result);
  }  
}

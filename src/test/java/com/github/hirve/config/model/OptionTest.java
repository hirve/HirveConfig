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
public class OptionTest {
  
  private final String testLine = "  aaa a( 1 , 2.0, 3,  \") = a1 b ('bbb')= b1 id (aaaId) c() = d ";

  /**
   *
   */
  public OptionTest() {
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
   * Test of getMethod method, of class Option.
   */
  @Test
  public void testGetMethod() {
    System.out.println("getMethod");
    Instruction instruction = new Instruction(testLine);
    String expResult = "a";
    String result = instruction.getOptions().get("a").getMethod();
    assertEquals(expResult, result);
  }

  /**
   * Test of getArgument method, of class Option.
   */
  @Test
  public void testGetArgument() {
    System.out.println("getArgument");
    Instruction instruction = new Instruction(testLine);
    String expResult = " 1 , 2.0, 3,  \"";
    String result = instruction.getOptions().get("a").getArgument();
    assertEquals(expResult, result);
  }

  /**
   * Test of setArgument method, of class Option.
   */
  @Test
  public void testSetArgument() {
    System.out.println("setArgument");
    Instruction instruction = new Instruction(testLine);
    instruction.getOptions().get("a").setArgument(" arg  ");
    String result = instruction.getOptions().get("a").getArgument();
    String expResult = " arg  ";
    assertEquals(expResult, result);
  }

  /**
   * Test of getOutputParameter method, of class Option.
   */
  @Test
  public void testGetOutputParameter() {
    System.out.println("getOutputParameter");
    Instruction instruction = new Instruction(testLine);
    String expResult = "a1";
    String result = instruction.getOptions().get("a").getOutputParameter();
    assertEquals(expResult, result);
  }

  /**
   * Test of toString method, of class Option.
   */
  @Test
  public void testToString() {
    System.out.println("toString");
    Option option = new Instruction(testLine).getOptions().get("a");
    String expResult = "a( 1 , 2.0, 3,  \") = a1";
    String result = option.toString();
    assertEquals(expResult, result);
  }
}

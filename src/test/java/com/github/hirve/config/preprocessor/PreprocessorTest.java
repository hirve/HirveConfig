/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.preprocessor;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 1
 */
public class PreprocessorTest {
  
  /**
   *
   */
  public PreprocessorTest() {
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
   * Test of apply method, of class Preprocessor.
   */
  @Test
  public void testApply() {
    System.out.println("apply");
    ArrayList<String> lines = new ArrayList<String>(){{
      add("a");
      add("  ");
      add("  b");
      add("");
      add("    c");
    }};
    List<String> result = new Preprocessor().apply(lines, null);
    assertEquals(5, result.size());
    assertEquals("a", result.get(0));
    assertEquals("  ", result.get(1));
    assertEquals("  b", result.get(2));
    assertEquals("", result.get(3));
    assertEquals("    c", result.get(4));
  }
  
}

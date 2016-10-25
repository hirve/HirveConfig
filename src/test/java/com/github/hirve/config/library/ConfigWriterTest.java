/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.library;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import com.github.hirve.config.testapi.TestApi;

/**
 *
 * @author 1
 */
public class ConfigWriterTest {
  
  private static final String configPath = "temp/ConfigWriterTest";

  /**
   *
   */
  public ConfigWriterTest() {
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
   * Test of write method, of class ConfigWriter.
   */
  @Test
  public void testWrite() {
    System.out.println("write");
    
    ArrayList<String> config = new ArrayList<>();
    config.add("line1");
    config.add("  line2");
    config.add("  #comment");
    config.add("  ");
    config.add("");
    ConfigWriter.write(configPath, config);
    
    ArrayList<String> lines = TestApi.readFile(configPath);
    assertEquals(5, lines.size());
    assertEquals("line1", lines.get(0));
    assertEquals("  line2", lines.get(1));
    assertEquals("  #comment", lines.get(2));
    assertEquals("  ", lines.get(3));
    assertEquals("", lines.get(4));
  }
}

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
public class PreferencesTest {
  
  private static final String configPath = "temp/PreferencesTest";

  /**
   *
   */
  public PreferencesTest() {
  }
  
  /**
   *
   */
  @BeforeClass
  public static void setUpClass() {
    ArrayList<String> config = new ArrayList<>();
    config.add("#comment\n");
    config.add("key1=value1\n");
    config.add("  key2 =value2\n");
    config.add("  #comment\n");
    config.add("  key3 = value3\n");
    config.add("  key4\n");
    config.add("  key5        \n");
    config.add("  \n");
    config.add("");
    TestApi.writeFile(configPath, config);
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
   * Test of read method, of class Preferences.
   */
  @Test
  public void testRead() {
    System.out.println("read");
    Preferences.read(configPath);
  }

  /**
   * Test of get method, of class Preferences.
   */
  @Test
  public void testGet() {
    System.out.println("get");
    Preferences.read(configPath);
    assertEquals("value1", Preferences.get("key1"));
    assertEquals("value2", Preferences.get("key2"));
    assertEquals("value3", Preferences.get("key3"));
  }

  /**
   * Test of get method, of class Preferences.
   */
  @Test
  public void testExists() {
    System.out.println("get");
    Preferences.read(configPath);
    assertTrue(Preferences.exists("key1"));
    assertTrue(Preferences.exists("key4"));
    assertTrue(Preferences.exists("key5"));
    assertFalse(Preferences.exists("key6"));
  }

  /**
   * Test of put method, of class Preferences.
   */
  @Test
  public void testPut() {
    System.out.println("put");
    Preferences.put("key4", "value4");
    assertEquals("value4", Preferences.get("key4"));
  }  
}

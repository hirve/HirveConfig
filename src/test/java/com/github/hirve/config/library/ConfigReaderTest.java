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
import java.io.File;
import java.util.List;

/**
 *
 * @author 1
 */
public class ConfigReaderTest {
  
  private static final String configPath = "temp/ConfigReaderTest";

  /**
   *
   */
  public ConfigReaderTest() {
  }
  
  /**
   *
   */
  @BeforeClass
  public static void setUpClass() {
    ArrayList<String> config = new ArrayList<>();
    config.add("line1\n");
    config.add("  line2\n");
    config.add("  #comment\n");
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
   * Test of read method, of class ConfigReader.
   */
  @Test
  public void testRead() {
    System.out.println("read");
    File file = new File(configPath);
    String absolutePath = file.getAbsolutePath();
    System.out.println("Test config absolute path: " + absolutePath);
    ConfigReader.read(configPath);
  }

  /**
   * Test of trimCommentsAndEmptyLines method, of class ConfigReader.
   */
  @Test
  public void testTrimCommentsAndEmptyLines() {
    System.out.println("trimCommentsAndEmptyLines");
    List<String> configFileLines = ConfigReader.read(configPath);
    ArrayList<String> expResult = new ArrayList<>();
    expResult.add("line1");
    expResult.add("  line2");
    List<String> result = ConfigReader.trimCommentsAndEmptyLines(configFileLines);
    assertEquals(expResult, result);
  }
}

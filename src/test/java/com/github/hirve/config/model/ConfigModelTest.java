/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.model;

import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;
import com.github.hirve.config.testapi.TestApi;

/**
 *
 * @author 1
 */
public class ConfigModelTest {

  private static final String configFilePath = "temp/ConfigModelTest";

  public ConfigModelTest() {
  }

  @BeforeClass
  public static void setUpClass() {

    ArrayList<String> config = new ArrayList<>();
    config.add("  aaa a(1)=a1 b(\"bbb\") = b1");
    config.add("    bbb a(2)=a2 b(bbb) = b2");
    config.add("    bbb a(a1) a2(a2) b(b1) b2 (b2)");
    config.add("      ccc c(b1)");
    TestApi.writeFile(configFilePath, config);
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
   * Test of parse method.
   * @throws java.lang.Exception
   */
  @Test
  public void testParse() throws Exception {
    System.out.println("parse");
    ConfigModel instance = new ConfigModel();
    instance.parse(configFilePath);
  }

  /**
   * Test of getConfig method.
   *
   * @throws java.lang.Exception
   */
  @Test
  public void testGetConfig() throws Exception {
    System.out.println("Test getConfig works");
    ConfigModel instance = new ConfigModel();
    instance.parse(configFilePath);
    assertTrue(instance.getConfig() instanceof Config);
  }
}

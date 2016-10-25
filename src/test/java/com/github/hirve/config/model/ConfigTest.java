/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.model;

import com.github.hirve.config.library.Exceptions;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 1
 */
public class ConfigTest {

  private static final ArrayList<String> lines = new ArrayList<>();
  private static final ArrayList<String> linesWithBrokenIndent = new ArrayList<>();
  private static final ArrayList<String> linesWithBrokenIndent2 = new ArrayList<>();

  /**
   *
   */
  public ConfigTest() {
  }

  /**
   *
   */
  @BeforeClass
  public static void setUpClass() {

    lines.add("  aaa id(aaaId)");
    lines.add("    aaa");
    lines.add("      bbb a(1,2,3,4,5) b(1) id(bbb1)");
    lines.add("    bbb a(1,2,3,4,5,6) b(2) id(bbb2)");

    linesWithBrokenIndent.add("  aaa id(aaaId)");
    linesWithBrokenIndent.add("    aaa");
    linesWithBrokenIndent.add("      bbb a(1,2,3,4,5) b(1) id(bbb1)");
    linesWithBrokenIndent.add("bbb a(1,2,3,4,5,6) b(2) id(bbb2)");

    linesWithBrokenIndent2.add("  aaa id(aaaId)");
    linesWithBrokenIndent2.add("    aaa");
    linesWithBrokenIndent2.add("      bbb a(1,2,3,4,5) b(1) id(bbb1)");
    linesWithBrokenIndent2.add("     bbb a(1,2,3,4,5) b(1) id(bbb1)");
    linesWithBrokenIndent2.add("  bbb a(1,2,3,4,5,6) b(2) id(bbb2)");
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
   * Test of Config method with broken config List.
   * @throws configtree.library.Exceptions.UnexpectedIndentException
   */
  @Test(expected = Exceptions.UnexpectedIndentException.class)
  public void testUnexpectedIndentException() throws Exceptions.UnexpectedIndentException {
    System.out.println("testUnexpectedIndentException");
    new Config(linesWithBrokenIndent);
  }

  /**
   * Test of Config method with broken config List 2.
   * @throws configtree.library.Exceptions.UnexpectedIndentException
   */
  @Test(expected = Exceptions.UnexpectedIndentException.class)
  public void testUnexpectedIndentException2() throws Exceptions.UnexpectedIndentException {
    System.out.println("testUnexpectedIndentException2");
    new Config(linesWithBrokenIndent2);
  }

  /**
   * Test of getRoot method, of class Config.
   * @throws configtree.library.Exceptions.UnexpectedIndentException
   */
  @Test
  public void testGetRoot() throws Exceptions.UnexpectedIndentException {
    System.out.println("getRoot");
    Config config = new Config(lines);
    String expResult = "root";
    String result = config.getRoot().toString();
    assertEquals(expResult, result);
  }

  /**
   * Test of getConfigNodeById method, of class Config.
   * @throws configtree.library.Exceptions.UnexpectedIndentException
   */
  @Test
  public void testGetConfigNodeById() throws Exceptions.UnexpectedIndentException {
    System.out.println("getConfigNodeById");
    Config config = new Config(lines);

    ConfigNode aaaIdNode = config.getConfigNodeById("aaaId");
    ConfigNode bbb1Node = config.getConfigNodeById("bbb1");

    assertEquals("  aaa id(aaaId)", aaaIdNode.toString());
    assertEquals("      bbb a(1,2,3,4,5) b(1) id(bbb1)", bbb1Node.toString());
    assertEquals(bbb1Node, aaaIdNode.getById("bbb1"));
  }
}

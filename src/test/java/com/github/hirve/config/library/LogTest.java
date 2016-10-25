/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.library;

import java.io.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author 1
 */
public class LogTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private PrintStream stdOut;

  /**
   *
   */
  public LogTest() {
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
    stdOut = new PrintStream(new FileOutputStream(FileDescriptor.out));
    System.setOut(new PrintStream(outContent));
  }

  /**
   *
   */
  @After
  public void tearDown() {
    System.setOut(stdOut);
  }

  /**
   * Test of log method, of class Log.
   */
  @Test
  public void testLog_String() {
    String message = "   aaa   ";
    Log.log(message);
    String result = outContent.toString().replaceAll("\r", "");
    String expResult = "   aaa   \n";
    assertEquals(expResult, result);
  }

  /**
   * Test of log method, of class Log.
   */
  @Test
  public void testLog_String_String() {
    String moduleName = "LogTest";
    String message = "   aaa   ";
    Log.log(moduleName, message);
    String result = outContent.toString().replaceAll("\r", "");
    String expResult = "   aaa   \n";
    assertEquals(expResult, result);
  }
}

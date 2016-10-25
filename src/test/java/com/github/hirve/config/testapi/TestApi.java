/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.testapi;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import java.util.logging.*;

/**
 *
 * @author 1
 */
public class TestApi {

  private static final double delta = 0.000001;

  /**
   * Asserts arrays length and equality of each element
   *
   * @param expected
   * @param result
   */
  public static void assertArrayEquals(double[] expected, double[] result) {
    assertEquals(expected.length, result.length);
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], result[i], delta);
    }
  }

  /**
   *
   * @param path
   * @param lines
   */
  public static void writeFile(String path, ArrayList<String> lines) {
    checkTempDir(path);
    try (FileWriter writer = new FileWriter(path)) {
      for (String line: lines) {
        writer.write(line + "\n");
      }
      writer.close();
    } catch (Exception e) {
      Logger.getLogger(TestApi.class.getName()).log(Level.SEVERE, null, e);
    }
  }

  /**
   *
   * @param path
   * @return
   */
  public static ArrayList<String> readFile(String path) {
    checkTempDir(path);
    ArrayList<String> lines = new ArrayList<>();
    try {
      lines = new ArrayList<>(Files.readAllLines(Paths.get(path)));
      printLines(lines);
    } catch (IOException e) {
      System.err.println(e);
    }
    return lines;
  }

  private static void printLines(ArrayList<String> lines) {
    System.out.println("TestApi readFile output");
    System.out.println("-----------------------");
    lines.stream().forEach((line) -> {
      System.out.println(line);
    });
    System.out.println("-----------------------");
  }

  private static void checkTempDir(String path) {
    Path tempDirPath = Paths.get(path).getParent();
    try {
      Files.createDirectories(tempDirPath);
    } catch (IOException e) {
      System.err.println(e);
    }
  }
}

/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.library;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.*;

/**
 *
 * @author 1
 */
public class ConfigWriter {

  private ConfigWriter() {}
  
  /**
   *
   * @param exportFileName
   * @param outputLinesList
   */
  public static void write(String exportFileName, List<String> outputLinesList) {
    try (FileWriter writer = new FileWriter(exportFileName)) {
      for (String line : outputLinesList) {
        writer.write(line + "\n");
      }
      writer.close();
    } catch (IOException e) {
      Logger.getLogger(ConfigWriter.class.getName()).log(Level.SEVERE, null, e);
    }
  }
}

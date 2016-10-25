/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.library;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;
import java.util.stream.Collectors;

/**
 *
 * @author 1
 */
public class ConfigReader {

  private ConfigReader() {}
  
  /**
   *
   * @param configFilePath
   * @return
   */
  public static List<String> read(String configFilePath) {
    return getConfigFileLines(configFilePath);
  }

  private static List<String> getConfigFileLines(String path) {
    List<String> outputList = new ArrayList<>();
    try {
      outputList = trimCommentsAndEmptyLines(new ArrayList<>(Files.readAllLines(Paths.get(path))));
    } catch (IOException e) {
      Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, null, e);
    }
    return outputList;
  }

  /**
   *
   * @param configFileLines
   * @return
   */
  public static List<String> trimCommentsAndEmptyLines(List<String> configFileLines) {
    return trimCommentLines(trimEmptyLines(configFileLines));
  }

  private static List<String> trimEmptyLines(List<String> configFileLines) {
    List<String> configFileLinesTrimmed;
    configFileLinesTrimmed = configFileLines.stream()
            .filter(line -> !line.trim().isEmpty())
            .collect(Collectors.toCollection(ArrayList::new));
    return configFileLinesTrimmed;
  }

  private static List<String> trimCommentLines(List<String> configFileLines) {
    List<String> configFileLinesTrimmed;
    configFileLinesTrimmed = configFileLines.stream()
            .filter(line -> ! "#".equals(line.trim().substring(0, 1)))
            .collect(Collectors.toCollection(ArrayList::new));
    return configFileLinesTrimmed;
  }
}

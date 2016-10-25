/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.library;

import java.util.*;
import java.util.regex.*;

/**
 *
 * @author 1
 */
public class Preferences {

  private static List<String> lines = new ArrayList<>();
  private static final Map<String, String> options = new HashMap<>();

  private Preferences() {}
  
  /**
   *
   * @param configFilePath
   */
  public static void read(String configFilePath) {
    lines = ConfigReader.read(configFilePath);
    lines.stream().forEach(line -> {
      addOption(line);
    });
  }

  private static void addOption(String line) {
    Pattern pattern = Pattern.compile("(\\w+)\\s*\\=\\s*([\\w\\/\\-\\.\\:]+)");
    Matcher matcher = pattern.matcher(line);
    if (matcher.find()) {
      options.put(matcher.group(1), matcher.group(2));
    } else {
      addKeyWithNoValue(line);
    }
  }

  private static void addKeyWithNoValue(String line) {
    Pattern pattern = Pattern.compile("(\\w+)\\s*");
    Matcher matcher = pattern.matcher(line);
    if (matcher.find()) {
      options.put(matcher.group(1), null);
    }
  }

  /**
   *
   * @param key
   * @return
   */
  public static String get(String key) {
    String value = options.get(key);
    return value != null ? value : "";
  }

  /**
   *
   * @param key
   * @return
   */
  public static Boolean exists(String key) {
    return options.containsKey(key);
  }

  /**
   *
   * @param key
   * @param value
   */
  public static void put(String key, String value) {
    options.put(key, value);
  }
}

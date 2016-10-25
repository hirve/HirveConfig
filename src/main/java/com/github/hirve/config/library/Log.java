/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.library;

/**
 *
 * @author 1
 */
public class Log {

  private Log() {}
  
  /**
   *
   * @param message
   */
  public static void log(String message) {
    if ("off".equals(Preferences.get("log"))) {
      return;
    }
    if ("true".equals(Preferences.get("logAddCaller"))) {
      StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
      System.out.println(stackTraceElements[2] + " " + message);
    } else {
      System.out.println(message);
    }
  }

  /**
   *
   * @param moduleName
   * @param message
   */
  public static void log(String moduleName, String message) {
    if (! "off".equals(Preferences.get("logOf" + moduleName))) {
      log(message);
    }
  }
}
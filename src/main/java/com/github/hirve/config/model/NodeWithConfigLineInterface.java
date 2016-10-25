/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.model;

/**
 *
 * @author 1
 * Specifies structure node configured with parameters described in config string,
 * usually the line of config file
 */
public interface NodeWithConfigLineInterface {
  
  /**
   *
   * @param line Set config line for node, should refresh all node's parameters depended on line
   */
  void setLine(String line);

  /**
   *
   * @return Returns node's config line
   */
  String getLine();
}

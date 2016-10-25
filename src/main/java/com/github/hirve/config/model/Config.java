/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.model;

import com.github.hirve.config.library.Exceptions;
import com.github.hirve.config.library.Log;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 1
 * @param <T>
 */
public class Config<T> {

  private final List<ConfigNode<T>> configNodesList = new ArrayList<>();
  private final ConfigNode<T> configRoot = new ConfigNode<>();

  /**
   *
   * @param configFileLines
   * @throws configtree.library.Exceptions.UnexpectedIndentException
   */
  public Config(List<String> configFileLines) throws Exceptions.UnexpectedIndentException {
    loadLines(configFileLines);
    Log.log("Config", "hierarchizeConfig:");
    hierarchizeConfig();
  }

  private void loadLines(List<String> configFileLines) {
    configFileLines.stream().forEach(line -> {
      configNodesList.add(new ConfigNode<>(line));
    });
  }

  private void hierarchizeConfig() throws Exceptions.UnexpectedIndentException {
    hierarchizeConfig(configRoot, 0, configNodesList.size() - 1);
  }

  private void hierarchizeConfig(ConfigNode<T> root, int fromIndex, int toIndex) throws Exceptions.UnexpectedIndentException {
    Log.log("Config", "->");

    int blockOffset = configNodesList.get(fromIndex).getOffset();
    int currentOffset;
    int fromIndexInner = 0;
    int toIndexInner;
    boolean isInnerBlockHere = false;
    ConfigNode<T> lastBlockOffsetConfigNode = null;

    for (int i = fromIndex; i <= toIndex; i++) {

      currentOffset = configNodesList.get(i).getOffset();

      // Check for negative offset inside the block
      if (currentOffset < blockOffset) {
        throw new Exceptions().new UnexpectedIndentException(i);
      }
      
      // Add current level child
      if (currentOffset == blockOffset) {
        Log.log("Config", configNodesList.get(i).getLine());
        lastBlockOffsetConfigNode = configNodesList.get(i);
        root.appendChild(lastBlockOffsetConfigNode);
      }

      // Check for inner block beginning
      if (!isInnerBlockHere && currentOffset > blockOffset) {
        fromIndexInner = i;
        isInnerBlockHere = true;
      }

      // Check for inner block ending or loop ending
      if (isInnerBlockHere && (i == toIndex || configNodesList.get(i + 1).getOffset() == blockOffset)) {
        toIndexInner = i;
        isInnerBlockHere = false;
        hierarchizeConfig(lastBlockOffsetConfigNode, fromIndexInner, toIndexInner);
      }
    }

    Log.log("Config", "<-");
  }

  public ConfigNode<T> getRoot() {
    return configRoot;
  }

  public ConfigNode<T> getConfigNodeById(String id) {
    return configRoot.getById(id);
  }
}

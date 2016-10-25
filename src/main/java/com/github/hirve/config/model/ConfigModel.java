/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.model;

import com.github.hirve.config.library.Preferences;
import com.github.hirve.config.library.ConfigReader;
import com.github.hirve.config.library.Exceptions;
import com.github.hirve.config.preprocessor.Preprocessor;
import java.util.List;

/**
 *
 * @author 1
 * @param <T> Special node class. An object specified with this class will be a part of each node.
 */
public class ConfigModel<T> {

  private Config<T> config;

  /**
   *
   */
  public ConfigModel() {
  }

  /**
   *
   * @param preferencesFilePathString Preferences file path
   */
  public ConfigModel(String preferencesFilePathString) {
    Preferences.read(preferencesFilePathString);
  }
  
  /**
   *
   * @param configFilePathString Config source file
   * @throws configtree.library.Exceptions.IncorrectSyntaxException
   * @throws configtree.library.Exceptions.EmptyConfigListException
   */
  public void parse(String configFilePathString)
          throws Exceptions.IncorrectSyntaxException, Exceptions.EmptyConfigListException {
    List<String> configFileLines = ConfigReader.read(configFilePathString);
    List<String> configFileLinesPreprocessed = new Preprocessor().apply(configFileLines, configFilePathString);
    config = new Config<>(configFileLinesPreprocessed);
  }

  /**
   *
   * @return DOM representation of config
   */
  public Config<T> getConfig() {
    return config;
  }
}

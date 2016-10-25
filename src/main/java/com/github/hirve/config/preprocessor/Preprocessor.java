/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.preprocessor;

import java.util.ArrayList;
import java.util.List;

public class Preprocessor {

  private final List<String> linesPreprocessed = new ArrayList<>();
  
  public List<String> apply(List<String> lines, String configFilePathString) {
    lines.stream().forEach(line -> {
      preprocessLine(line);
    });
    return linesPreprocessed;
  }

  private void preprocessLine(String line) {
    linesPreprocessed.add(line);
  }
}

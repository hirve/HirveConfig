/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.model;

import com.github.hirve.config.library.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Instruction {

  private String keyword;
  private final Map<String, Option> options = new HashMap<>();

  Instruction(String line) {
    takeKeyword(line);
    takeOptions(line);
  }

  private void takeKeyword(String line) {
    Pattern pattern = Pattern.compile("^\\s*(\\w+)");
    Matcher matcher = pattern.matcher(line);
    if (matcher.find()) {
      keyword = matcher.group(1);
      Log.log("Instruction", "new Instruction:\t" + keyword);
    }
  }

  private void takeOptions(String line) {
    Pattern pattern = Pattern.compile("(\\w+\\s*\\(.*?\\)(\\s*\\=\\s*\\w+)?)");
    Matcher matcher = pattern.matcher(line);
    while (matcher.find()) {
      Option option = new Option(matcher.group(1));
      String method = option.getMethod();
      options.put(method, option);
    }
  }

  public String getKeyword() {
    return keyword;
  }
  public void setKeyword(String keyword) {
    this.keyword = keyword;
  }

  public Map<String, Option> getOptions() {
    return options;
  }
}

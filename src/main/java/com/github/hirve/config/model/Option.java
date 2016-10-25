/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.model;

import com.github.hirve.config.library.Log;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Option {

  private String method;
  private String argument;
  private String outputParameter;
  private String optionString;

  public Option(String optionString) {
    Log.log("Option", "new Option:\t\t  " + optionString);
    this.optionString = optionString;
    parseOption();
  }

  private void parseOption() {
    Pattern pattern = Pattern.compile("(\\w+)\\s*\\((.*?)\\)(\\s*\\=\\s*(\\w+))?");
    Matcher matcher = pattern.matcher(optionString);
    if (matcher.find()) {
      method = matcher.group(1);
      Log.log("Option", "Option parse:\t\t\tMethod: " + method);
      argument = matcher.group(2);
      Log.log("Option", "Option parse:\t\t\tArgument: " + argument);
      outputParameter = matcher.group(4);
      Log.log("Option", "Option parse:\t\t\tOutput Parameter: " + outputParameter);
    }
  }

  public String getMethod() {
    return method;
  }

  public String getArgument() {
    return argument;
  }
  public void setArgument(String argument) {
    this.argument = argument;
    optionString = method + "(" + argument + ")" + (outputParameter != null ? "=" + outputParameter : "");
  }

  public String getOutputParameter() {
    return outputParameter;
  }

  @Override
  public String toString() {
    return optionString;
  }
}

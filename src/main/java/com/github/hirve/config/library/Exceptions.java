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
public class Exceptions {

  // Top level exceptions
  /**
   *
   */
  public class IncorrectSyntaxException extends Exception {
    public IncorrectSyntaxException(String message) {
      super(message);
    }
  }

  /**
   *
   */
  public class EmptyConfigListException extends Exception {
    public EmptyConfigListException(String message) {
      super(message);
    }
  }

  // Specific exceptions
  /**
   *
   */
  public class UnexpectedIndentException extends IncorrectSyntaxException {
    public UnexpectedIndentException(int lineNumber) {
      super("Unexpected indent in line " + lineNumber);
    }
  }

  /**
   *
   */
  public class UnknownIdentifierInArgumentList extends IncorrectSyntaxException {
    public UnknownIdentifierInArgumentList(int lineNumber) {
      super("Undefined identifier in line " + lineNumber);
    }
  }
}

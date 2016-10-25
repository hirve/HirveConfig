/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.model;

import java.util.List;

/**
 *
 * @author 1
 * @param <T>
 */
public interface NodeTreeInterface<T> {
  
  /**
   *
   * @param t
   */
  void setParent(T t);

  /**
   *
   * @return
   */
  T getParent();

  /**
   *
   * @param t
   */
  void appendChild(T t);

  /**
   *
   * @return
   */
  List<T> getChilds();

  /**
   *
   * @return
   */
  T getRoot();

  /**
   *
   * @return
   */
  boolean isRoot();

  /**
   *
   * @param t
   * @return
   */
  boolean isInTreeOf(T t);
}

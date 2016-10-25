/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.model;

/**
 *
 * @author 1
 * @param <T>
 */
public interface NodeWithIdInterface<T> {

  /**
   *
   * @param id
   */
  void setId(String id);

  /**
   *
   * @return
   */
  String getId();

  /**
   *
   * @param id
   * @return
   */
  T getById(String id);
}
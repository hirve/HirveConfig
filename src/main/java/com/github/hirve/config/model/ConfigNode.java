/*
 * This code is free software, you can use it in any way useful for world peace.
 * Do alter or remove this copyright file header.
 * This code is extremely useful, but comes without any warranty.
 */
package com.github.hirve.config.model;

import com.github.hirve.config.library.Log;
import java.util.ArrayList;
import java.util.List;

public class ConfigNode<T> implements NodeWithConfigLineInterface, NodeTreeInterface<ConfigNode<T>>, NodeWithIdInterface<ConfigNode<T>> {

  private String id;
  private int offset;
  private String line;
  private ConfigNode<T> parentNode;
  private final List<ConfigNode<T>> childNodes = new ArrayList<>();
  private Instruction instruction;
  private T structureNode = null;

  public ConfigNode() {
    this.line = "root";
    setAsRoot();
    Log.log("ConfigNode", "new ConfigNode:\t\troot");
  }

  public ConfigNode(String line) {
    initialize(line);
  }

  private void initialize(String line) {
    this.line = line;
    this.offset = line.indexOf(line.trim());
    Log.log("ConfigNode", "new ConfigNode:\t\t" + line.trim());
    instruction = new Instruction(line);
    Option idOption = instruction.getOptions().get("id");
    if (idOption != null) {
      this.id = idOption.getArgument();
    }
  }

  public Instruction getInstruction() {
    return instruction;
  }

  @Override
  public String getId() {
    return id;
  }
  @Override
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String getLine() {
    return line;
  }
  @Override
  public void setLine(String line) {
    initialize(line);
  }
  @Override
  public String toString() {
    return getLine();
  }

  public int getOffset() {
    return offset;
  }

  public T getStructureNode() {
    return structureNode;
  }
  public void setStructureNode(T structureNode) {
    this.structureNode = structureNode;
  }

  @Override
  public void appendChild(ConfigNode<T> configNode) {
    configNode.setParent(this);
    childNodes.add(configNode);
  }
  @Override
  public List<ConfigNode<T>> getChilds() {
    return childNodes;
  }

  @Override
  public void setParent(ConfigNode<T> parentNode) {
    this.parentNode = parentNode;
  }
  @Override
  public ConfigNode<T> getParent() {
    return parentNode;
  }

  private void setAsRoot() {
    offset = -1;
  }
  @Override
  public boolean isRoot() {
    return offset == -1;
  }

  @Override
  public ConfigNode<T> getRoot() {
    if (this.isRoot()) {
      return this;
    }
    ConfigNode<T> node = this;
    while (!node.isRoot()) {
      node = node.parentNode;
    }
    return node;
  }

  @Override
  public boolean isInTreeOf(ConfigNode<T> root) {
    ConfigNode<T> current = this;
    while (current != null) {
      if (root == current) {
        return true;
      }
      current = current.parentNode;
    }
    return false;
  }

  @Override
  public ConfigNode<T> getById(String id) {
    if (this.id != null && this.id.equals(id)) {
      return this;
    } else {
      for (ConfigNode<T> node: this.getChilds()) {
        ConfigNode<T> nodeFound = node.getById(id);
        if (nodeFound != null) {
          return nodeFound;
        }
      }
      return null;
    }
  }
}

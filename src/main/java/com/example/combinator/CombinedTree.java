package com.example.combinator;

import java.util.List;

public class CombinedTree<T> {
  private RootNode<T> rootNode;

  public CombinedTree() {
    this.rootNode = new RootNode<T>();
  }

  public RootNode<T> getRootNode() {
    return rootNode;
  }

  public CombinedTree<T> combineArray(T[] array) {
    processCombinations(array, 0, rootNode);
    return this;
  }

  public List<List<T>> getCombinations() {
    return rootNode.getCombinations();
  }

  private void processCombinations(T[] array, int startIndex, RootNode<T> node) {
    for (int i = startIndex; i < array.length; i++) {
      final CombinedNode<T> newNode = node.createChild(array[i]);
      processCombinations(array, i + 1, newNode);
    }
  }

}

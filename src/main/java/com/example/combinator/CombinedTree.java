package com.example.combinator;

public class CombinedTree<T> {
  private RootNode<T> rootNote;

  public CombinedTree() {
    this.rootNote = new RootNode<T>();
  }

  public RootNode<T> getRootNode() {
    return rootNote;
  }

  public CombinedTree<T> combineArray(T[] array) {
    processCombinations(array, 0, rootNote);
    return this;
  }

  private void processCombinations(T[] array, int startIndex, RootNode<T> node) {
    for (int i = startIndex; i < array.length; i++) {
      final CombinedNode<T> newNode = node.createChild(array[i]);
      processCombinations(array, i + 1, newNode);
    }
  }

}

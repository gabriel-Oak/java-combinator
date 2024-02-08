package com.example.combinator;

import java.util.Optional;

public class CombinedTreeOptimized<T> {
  private RootNode<T> rootNode;

  public CombinedTreeOptimized() {
    this.rootNode = new RootNode<T>();
  }

  public RootNode<T> getRootNode() {
    return rootNode;
  }

  public CombinedTreeOptimized<T> combineArray(T[] array) {
    processCombinations(array, 0, rootNode);
    return this;
  }

  private void processCombinations(T[] array, int startIndex, RootNode<T> node) {
    for (int i = startIndex; i < array.length; i++) {
      final Optional<CombinedNode<T>> existingNodeOptional = rootNode.getChildAt(i);
      if (existingNodeOptional.isPresent()) {
        final CombinedNode<T> existingNode = existingNodeOptional.get();
        if (node != rootNode) {
          node.appendChild(existingNode);
        }
      } else {
        final CombinedNode<T> newNode = node.createChild(array[i]);
        if (node != rootNode) {
          rootNode.appendChild(newNode);
        }

        processCombinations(array, i + 1, newNode);
      }
    }
  }

}

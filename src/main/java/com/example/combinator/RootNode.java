package com.example.combinator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RootNode<T> {

  protected List<CombinedNode<T>> childNodes = new ArrayList<CombinedNode<T>>();

  public Optional<CombinedNode<T>> getChildAt(int index) {
    if (index >= childNodes.size())
      return Optional.empty();
    return Optional.of(childNodes.get(index));
  }

  public CombinedNode<T> createChild(T childValue) {
    final CombinedNode<T> child = new CombinedNode<T>(childValue);
    this.childNodes.add(child);

    return child;
  }

  public void appendChild(CombinedNode<T> child) {
    childNodes.add(child);
  }

  public List<List<T>> getCombinations() {
    List<List<T>> values = new ArrayList<List<T>>();

    for (CombinedNode<T> child : childNodes) {
      final List<List<T>> childValuesMatrix = child.getCombinations();
      childValuesMatrix.forEach((childValuesList) -> {
        values.add(childValuesList);
      });
    }

    return values;
  }

  @Override
  public String toString() {
    return "childs: " + String.join("; ", childNodes
        .stream()
        .map(node -> node
            .getValue()
            .toString())
        .collect(Collectors.toList()));
  }
}

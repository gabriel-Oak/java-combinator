package com.example.combinator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinedNode<T> extends RootNode<T> {
  private T value;

  public CombinedNode(T value) {
    this.value = value;
  }

  public T getValue() {
    return value;
  }

  @Override
  public List<List<T>> getCombinations() {
    List<List<T>> values = new ArrayList<List<T>>();
    values.add(new ArrayList<T>(Arrays.asList(value)));

    for (CombinedNode<T> child : childNodes) {
      final List<List<T>> childValuesMatrix = child.getCombinations();
      childValuesMatrix.forEach((childValuesList) -> {
        childValuesList.add(value);
        values.add(childValuesList);
      });
    }

    return values;
  }

  @Override
  public String toString() {
    return "self: " + value.toString() + "; " + super.toString();
  }
}

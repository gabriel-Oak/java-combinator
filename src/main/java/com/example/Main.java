package com.example;

import java.util.ArrayList;
import java.util.Arrays;

import com.example.combinator.CombinedTree;
import com.example.combinator.CombinedTreeOptimized;

public class Main {
    public static void main(String[] args) {
        final Integer[] arr = { 1, 2, 3, 4 };
        long startTime = System.nanoTime();
        final CombinedTree<Integer> tree = new CombinedTree<Integer>();
        tree.combineArray(arr);
        System.out.println(tree.getCombinations());

        long stopTime = System.nanoTime();
        long firstOp = stopTime - startTime;

        // =================================================================
        startTime = System.nanoTime();
        final CombinedTreeOptimized<Integer> treeOptimized = new CombinedTreeOptimized<Integer>();
        treeOptimized.combineArray(arr);
        System.out.println(treeOptimized.getCombinations());

        stopTime = System.nanoTime();
        long secondOp = stopTime - startTime;

        // =================================================================
        final CombinedTreeOptimized<Integer> treeOptimized2 = CombinedTreeOptimized.ofArray(arr);
        System.out.println(treeOptimized2.getCombinations());

        // =================================================================
        final CombinedTreeOptimized<Integer> treeOptimized3 = CombinedTreeOptimized.ofList(Arrays.asList(arr));
        System.out.println(treeOptimized3.getCombinations());

        System.out.println(firstOp);
        System.out.println(secondOp);

        System.out.println(firstOp - secondOp);
    }
}
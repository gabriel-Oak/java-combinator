package com.example;

import com.example.combinator.CombinedTree;
import com.example.combinator.CombinedTreeOptimized;

public class Main {
    public static void main(String[] args) {
        final Integer[] arr = { 1, 2, 3, 4 };
        long startTime = System.nanoTime();
        final CombinedTree<Integer> tree = new CombinedTree<Integer>();
        tree.combineArray(arr);
        System.out.println(tree.getRootNode());
        System.out.println(tree.getRootNode().getCombinations());

        long stopTime = System.nanoTime();
        long firstOp = stopTime - startTime;

        // =================================================================
        startTime = System.nanoTime();
        final CombinedTreeOptimized<Integer> treeOpt = new CombinedTreeOptimized<Integer>();
        treeOpt.combineArray(arr);
        System.out.println(treeOpt.getRootNode());
        System.out.println(treeOpt.getRootNode().getCombinations());

        stopTime = System.nanoTime();
        long secondOp = stopTime - startTime;

        System.out.println(firstOp);
        System.out.println(secondOp);

        System.out.println(firstOp - secondOp);
    }
}
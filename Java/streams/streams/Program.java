package com.debuggeando_ideas.streams;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.Optional;

class Program {
    public static void main(String[] args) {
       List<Integer> values = Arrays.asList(10,4,2,1,5,17,19,18);
        System.out.println(reconstructBst(values));
    }
    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    private static BST reconstructBst(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.size() == 0) {
            return null;
        }
        int[] idx = {0};
        //int currentValue = preOrderTraversalValues.get(0);
        Optional<Integer> currentValue = preOrderTraversalValues.stream().findFirst();
        currentValue.get();
        AtomicInteger rightSubtreeRootIdx = new AtomicInteger(preOrderTraversalValues.size());
        List<Integer> values = preOrderTraversalValues.stream().filter(v -> v > currentValue.get()).collect(Collectors.toList());
        values.stream().forEach(value -> {
            idx[0]++;
            //System.out.println(idx[0]);
            if (value >= currentValue.get()) {
                rightSubtreeRootIdx.set(idx[0]);
                return;
            }
        });

    /*
    for (int idx = 1; idx < preOrderTraversalValues.size(); idx++){
      int value = preOrderTraversalValues.get(idx);
      System.out.println("value " + value);
      System.out.println("currentValue " + currentValue);
      if (value >= currentValue.get()) {
        rightSubtreeRootIdx = idx;
        break;
      }
    }*/
    System.out.println(idx[0] +" - "+rightSubtreeRootIdx);
        BST leftSubtree = reconstructBst(preOrderTraversalValues.subList(1, rightSubtreeRootIdx.get()));
        BST rightSubtree = reconstructBst(preOrderTraversalValues.subList(rightSubtreeRootIdx.intValue(), preOrderTraversalValues.size()));
        BST bst = new BST(currentValue.get());
        bst.left = leftSubtree;
        bst.right = rightSubtree;
        return bst;
    }



}
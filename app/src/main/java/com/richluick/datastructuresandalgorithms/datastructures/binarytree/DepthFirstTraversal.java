package com.richluick.datastructuresandalgorithms.datastructures.binarytree;

import android.util.Log;

/**
 * Created by rluic on 1/29/2017.
 */

public class DepthFirstTraversal {

    public static void preOrder(TreeNode<Character> root) {
        if (root == null) {
            return;
        }

        Log.e("Process GraphNode", String.valueOf(root.getData()));
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public static void inOrder(TreeNode<Character> root) {
        if (root == null) {
            return;
        }

        preOrder(root.getLeftChild());
        Log.e("Process GraphNode", String.valueOf(root.getData()));
        preOrder(root.getRightChild());
    }

    public static void postOrder(TreeNode<Character> root) {
        if (root == null) {
            return;
        }

        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
        Log.e("Process GraphNode", String.valueOf(root.getData()));
    }
}

package com.richluick.datastructuresandalgorithms.datastructures.binarytree;

/**
 * Created by rluic on 1/29/2017.
 */

public class BinarySearchTree<T> {

    private TreeNode head;

    public BinarySearchTree(TreeNode head) {
        this.head = head;
    }

    public TreeNode insert(TreeNode<Integer> node) {
        return insert(head, node);
    }

    private TreeNode<Integer> insert(TreeNode<Integer> head, TreeNode<Integer> node) {
        if (head == null) {
            return node;
        }

        if (node.getData() <= head.getData()) {
            head.setLeftChild(insert(head.getLeftChild(), node));
        } else {
            head.setRightChild(insert(head.getRightChild(), node));
        }

        return head;
    }
}

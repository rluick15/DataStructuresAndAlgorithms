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

    public TreeNode<Integer> lookup(int data) {
        return lookup(head, data);
    }

    private TreeNode<Integer> lookup(TreeNode<Integer> head, int data) {
        if (head == null) {
            return null;
        }

        if (data == head.getData()) {
            return head;
        }

        if(data < head.getData()) {
            return lookup(head.getLeftChild(), data);
        } else {
            return lookup(head.getRightChild(), data);
        }
    }

    public int getMinimumValue() {
        return getMinimumValue(head);
    }

    private int getMinimumValue(TreeNode<Integer> node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        if (node.getLeftChild() == null) {
            return node.getData();
        }
        return getMinimumValue(node.getLeftChild());
    }

    public int getMaxDepth(TreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        if (node.getLeftChild() == null && node.getRightChild() == null) {
            return 0;
        }

        int leftMax = 1 + getMaxDepth(node.getLeftChild());
        int rightMax = 1 + getMaxDepth(node.getRightChild());

        return Math.max(leftMax, rightMax);
    }

    public void mirrorTree(TreeNode<Integer> node) {
        if (node == null) {
            return;
        }

        TreeNode<Integer> leftNode = node.getLeftChild();
        node.setLeftChild(node.getRightChild());
        node.setRightChild(leftNode);

        mirrorTree(node.getLeftChild());
        mirrorTree(node.getRightChild());
    }

    public void numberOfUniqueTrees() {

    }
}

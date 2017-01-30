package com.richluick.datastructuresandalgorithms.datastructures.binarytree;

/**
 * Created by rluic on 1/29/2017.
 */

public class TreeNode<T> {

    private T data;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }
}

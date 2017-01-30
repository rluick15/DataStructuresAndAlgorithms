package com.richluick.datastructuresandalgorithms.datastructures.binarytree;

import com.richluick.datastructuresandalgorithms.datastructures.queue.Queue;
import com.richluick.datastructuresandalgorithms.datastructures.queue.QueueOverflowException;
import com.richluick.datastructuresandalgorithms.datastructures.queue.QueueUnderflowException;

/**
 * Created by rluic on 1/29/2017.
 */

public class BradthFirst {

    public static void breadthFirst(TreeNode root) throws QueueUnderflowException, QueueOverflowException {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new Queue<>(TreeNode.class);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.dequeue();

            if (treeNode.getLeftChild() != null) {
                queue.enqueue(treeNode.getLeftChild());
            }
            if (treeNode.getRightChild() != null) {
                queue.enqueue(treeNode.getRightChild());
            }
        }
    }
}

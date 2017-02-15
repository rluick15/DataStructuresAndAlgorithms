package com.richluick.datastructuresandalgorithms;

import com.richluick.datastructuresandalgorithms.datastructures.binarytree.TreeNode;
import com.richluick.datastructuresandalgorithms.datastructures.graph.Graph;
import com.richluick.datastructuresandalgorithms.datastructures.linkedlist.LinkedList;
import com.richluick.datastructuresandalgorithms.datastructures.queue.Queue;
import com.richluick.datastructuresandalgorithms.datastructures.queue.QueueOverflowException;
import com.richluick.datastructuresandalgorithms.datastructures.queue.QueueUnderflowException;
import com.richluick.datastructuresandalgorithms.datastructures.stack.Stack;
import com.richluick.datastructuresandalgorithms.datastructures.stack.StackOverflowException;
import com.richluick.datastructuresandalgorithms.datastructures.stack.StackUnderflowException;

import java.util.Arrays;

/**
 * Created by rluic on 2/14/2017.
 */

public class AlgorithmPractice {

    public boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);

        char[] c2 = s2.toCharArray();
        Arrays.sort(c2);

        return Arrays.equals(c1, c2);
    }

    public String replaceSpace(String string) {
        StringBuilder builder = new StringBuilder();

        for (char c : string.toCharArray()) {
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }

    public void removeMiddleLLNode(LinkedList.Node node) {
        if (node.getNext() == null) {
            return;
        }

        LinkedList.Node next = node.getNext();
        node.setData(next.getData());
        node.setNext(next.getNext());

    }

    public void sortStack(Stack<Integer> stack) throws StackUnderflowException, StackOverflowException {
        if (stack.getSize() == 0) {
            return;
        }

        Stack<Integer> ascendingStack = new Stack<>();
        ascendingStack.push(stack.pop());

        int num;
        while (!stack.isEmpty()) {
            num = stack.pop();
            if (num < ascendingStack.peek()) {
                while (num < ascendingStack.peek()) {
                    stack.push(ascendingStack.pop());
                }
            }
            ascendingStack.push(num);
        }
    }

    public void breadthFirstTree(TreeNode<Integer> node) throws QueueOverflowException, QueueUnderflowException {
        if (node == null) {
            return;
        }

        Queue<TreeNode> queue = new Queue<>(TreeNode.class);
        queue.enqueue(node);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.dequeue();

            //process

            if (treeNode.getLeftChild() != null) {
                queue.enqueue(treeNode.getLeftChild());
            }

            if (treeNode.getRightChild() != null) {
                queue.enqueue(treeNode.getRightChild());
            }
        }
    }

    public void depthFirstTree(TreeNode<Integer> node) {
        if (node == null) {
            return;
        }

        //preorder process
        depthFirstTree(node.getLeftChild());
        //inorder process
        depthFirstTree(node.getRightChild());
        //post order process
    }


    private TreeNode<Integer> treeHead;

    public void insertTreeNode(TreeNode<Integer> node) {
        if (treeHead == null) {
            treeHead = node;
            return;
        }

        insertTreeNode(treeHead, node);
    }

    private TreeNode<Integer> insertTreeNode(TreeNode<Integer> head, TreeNode<Integer> node) {
        if (head == null) {
            return node;
        }

        if (node.getData() <= head.getData()) {
            head.setLeftChild(insertTreeNode(head.getLeftChild(), node));
        } else {
            head.setRightChild(insertTreeNode(head.getRightChild(), node));
        }

        return head;
    }

    public void breadthFirstGraph(Graph graph, int currentVertex) throws QueueOverflowException, QueueUnderflowException {
        if (graph == null) {
            return;
        }

        int[] visited = new int[graph.getNumVertices()];
        Queue<Integer> queue = new Queue<>(Integer.class);
        queue.enqueue(currentVertex);

        while (!queue.isEmpty()) {
            int data = queue.dequeue();

            if (visited[data] == 1) {
                continue;
            }
            visited[data] = 1;
            //process

            for (int vertex : graph.getAdjacentVertices(data)) {
                queue.enqueue(data);
            }
        }
    }

    public void depthFirstGraph(Graph graph, int[] vertexList, int currentVertex) {
        if (vertexList[currentVertex] == 1) {
            return;
        }

        vertexList[currentVertex] = 1;

        //process

        for (int adjVertex : graph.getAdjacentVertices(currentVertex)) {
            depthFirstGraph(graph, vertexList, adjVertex);
        }
    }
}

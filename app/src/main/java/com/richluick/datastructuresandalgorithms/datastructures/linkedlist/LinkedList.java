package com.richluick.datastructuresandalgorithms.datastructures.linkedlist;

/**
 * Created by rluick on 1/19/2017.
 */
public class LinkedList<T> {

    private Node<T> head;

    public void addNode(T data) {
        Node<T> node = new Node(data, null);

        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (head.getNext() != null) {
                current = head.getNext();
            }
            current.setNext(node);
        }
    }

    public int getCount() {
        int counter = 0;
        if (head == null) {
            return counter;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
                counter++;
            }
            return counter;
        }
    }

    public T pop() {
        if (head == null) {
            return null;
        } else {
            T data = head.getData();
            head = head.getNext();
            return data;
        }
    }

    public class Node<T> {

        private T data;
        private Node next;

        public Node(T data, Node<T> next) {
            this.data = data;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}

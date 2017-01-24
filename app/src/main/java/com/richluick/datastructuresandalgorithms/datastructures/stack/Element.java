package com.richluick.datastructuresandalgorithms.datastructures.stack;

/**
 * Created by rluick on 1/19/2017.
 */

public class Element<D> {

    private D data;
    private Element next;

    public Element(D data, Element next) {
        this.data = data;
        this.next = next;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}

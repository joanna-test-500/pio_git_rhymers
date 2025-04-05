package edu.kis.vh.nursery.list;

public class IntLinkedList {
    private static final int EMPTY_RHYMER_VALUE = -1;
    private Node last;
    private int i;

    // Inner Node class
    private class Node {
        private int value;
        private Node prev, next;

        public Node(int i) {
            value = i;
        }

        public int getValue() {
            return value;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void push(int i) {
        if (last == null)
            last = new Node(i);
        else {
            Node newNode = new Node(i);
            newNode.setPrev(last);
            last.setNext(newNode);
            last = newNode;
        }
    }

    public boolean isEmpty() {
        return last == null;
    }

    public boolean isFull() {
        return false;
    }

    public int top() {
        if (isEmpty())
            return EMPTY_RHYMER_VALUE;
        return last.getValue();
    }

    public int pop() {
        if (isEmpty())
            return -1;
        int ret = last.getValue();
        last = last.getPrev();
        return ret;
    }
}

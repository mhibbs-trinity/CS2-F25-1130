package cs2.adt;

public class LinkedQueue<T> extends Queue<T> {
    private class Node {
        public T data;
        public Node next;
        public Node(T d, Node n) {
            data = d; next = n;
        }
    }

    private Node head;
    private Node last;

    public LinkedQueue() {
        head = null;
        last = null;
    }

    public void enqueue(T elem) {
        if(isEmpty()) {
            last = new Node(elem, null);
            head = last;
        } else {
            last.next = new Node(elem, null);
            last = last.next;
        }
    }
    public T dequeue() {
        if(isEmpty()) throw new EmptyQueueException();
        T tmp = head.data;
        head = head.next;
        if(head == null) last = null;
        return tmp;
    }
    public T peek() {
        if(isEmpty()) throw new EmptyQueueException();
        return head.data;
    }
    public boolean isEmpty() {
        return head == null && last == null;
    }
}

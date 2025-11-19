package cs2.adt;

public class LinkedPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {
    private class Node {
        public T data;
        public Node next;
        public Node(T d, Node n) {
            data = d; next = n;
        }
    }

    private Node head;
    public LinkedPriorityQueue() {
        head = null;
    }

    public void add(T elem) {
        if(head == null || elem.compareTo(head.data) > 0) {
            head = new Node(elem, head);
        } else {
            Node rover = head;
            while(rover.next != null && rover.next.data.compareTo(elem) > 0) {
                rover = rover.next;
            }
            rover.next = new Node(elem, rover.next);
        }
    }
    public T get() {
        T tmp = head.data;
        head = head.next;
        return tmp;
    }
    public T peek() {
        return head.data;
    }

    /*
    public void add(T elem) {
        head = new Node(elem, head);
    }
    public T get() {
        Node rover = head;
        Node biggest = head;
        Node obb = null;
        Node beforeRover = null;

        while(rover != null) {
            if(rover.data.compareTo(biggest.data) > 0) {
                biggest = rover;
                obb = beforeRover;
            }
            beforeRover = rover;
            rover = rover.next;
        }
        if(obb == null) {
            head = head.next;
        } else {
            obb.next = obb.next.next;
        }

        return biggest.data;

    }
    public T peek() {
        T largest = head.data;
        Node rover = head;
        while(rover != null) {
            if(rover.data.compareTo(largest) > 0) {
                largest = rover.data;
            }
            rover = rover.next;
        }
        return largest;
    }
    */
    public boolean isEmpty() {
        return head == null;
    }

}

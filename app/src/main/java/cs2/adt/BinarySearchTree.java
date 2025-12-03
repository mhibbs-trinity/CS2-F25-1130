package cs2.adt;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
    private class Node {
        public T data; public Node left; public Node right;
        public Node(T d, Node l, Node r) {
            data = d; left = l; right = r;
        }
        public boolean contains(T elem) {
            if(data.compareTo(elem) == 0) return true;
            if(data.compareTo(elem) < 0) {
                if(right == null) return false;
                return right.contains(elem);
            } else {
                if(left == null) return false;
                return left.contains(elem);
            }
        }
        public void insert(T elem) {
            if(data.compareTo(elem) < 0) {
                if(right == null) right = new Node(elem, null, null);
                else right.insert(elem);
            } else {
                if(left == null) left = new Node(elem, null, null);
                left.insert(elem);
            }
        }

        public MaxResult passUpMax() {
            if(right == null) {
                return new MaxResult(data,left);
            } else {
                MaxResult mr = right.passUpMax();
                right = mr.kid;
                return new MaxResult(data, this);
            }
        }

        public Node remove(T elem) {
            if(elem.compareTo(data) == 0) {
                //Found it!
                if(left == null) {
                    return right;
                } else if (right == null) {
                    return left;
                } else {
                    MaxResult mr = left.passUpMax();
                    left = mr.kid;
                    data = mr.data;
                    return this;
                }
            } else {
                if(elem.compareTo(data) < 0) {
                    left = left.remove(elem);
                } else {
                    right = right.remove(elem);
                }
                return this;
            }
        }

    }

    public class MaxResult {
        public T data;
        public Node kid;
        public MaxResult(T d, Node n) { data = d; kid = n;}
    }


    private Node root;
    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty() { return root == null; }
    public void remove(T elem) {
        root = root.remove(elem);
    }
    public void insert(T elem) {
        if(root == null) root = new Node(elem, null, null);
        root.insert(elem);
    }
    public boolean contains(T elem) {
        if(root == null) return false;
        return root.contains(elem);
        /*
        Node current = root;
        while(current != null) {
            if(current.data.compareTo(elem) == 0) return true;
            if(current.data.compareTo(elem) < 0) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return false;
        */
    }

    public void helperPreOrder(Node curr) {
        System.out.print(curr.data + ",");
        if(curr.left != null) helperPreOrder(curr.left);
        if(curr.right != null) helperPreOrder(curr.right);
    }
    public void printPreOrder() {
        if(root != null) helperPreOrder(root);
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            LinkedStack<Node> s = new LinkedStack<>();
            { if(root != null) s.push(root); }
            public boolean hasNext() {
                return !s.isEmpty();
            }
            public T next() {
                Node curr = s.pop();
                if(curr.right != null) s.push(curr.right);
                if(curr.left != null) s.push(curr.left);
                return curr.data;
            }
        };
    }

    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.insert("Hello");
        tree.insert("Goodbye");
        tree.insert("White");

        Iterator<String> it = tree.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        for(String s : tree) {
            System.out.println(s);
        }

    }


    
}

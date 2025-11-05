package cs2.adt;

public abstract class Stack<T> {
    public abstract void push(T elem);
    public abstract T pop();
    public abstract T peek();
    public abstract boolean isEmpty();
}


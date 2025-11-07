package cs2.adt;

public abstract class Queue<T> {
    public abstract void enqueue(T elem);
    public abstract T dequeue();
    public abstract T peek();
    public abstract boolean isEmpty();
}

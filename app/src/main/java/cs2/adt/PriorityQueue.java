package cs2.adt;

public interface PriorityQueue<T extends Comparable<T>> {
    public void add(T elem);
    public T get();
    public T peek();
    public boolean isEmpty();
}

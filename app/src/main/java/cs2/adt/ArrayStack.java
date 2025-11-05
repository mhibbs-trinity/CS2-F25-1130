package cs2.adt;

public class ArrayStack<T> extends Stack<T> {
    private int len;
    private T[] arr;

    public ArrayStack() {
        len = 0;
        arr = (T[])new Object[10];
    }

    public void push(T elem) {
        if(arr.length == len) {
            T[] tmp = (T[]) new Object[len * 2];
            for(int i=0; i<arr.length; i++) {
                tmp[i] = arr[i];
            }
            arr = tmp;
        }
        arr[len] = elem;
        len++;
    }
    public T peek() {
        return arr[len-1];
    }
    public T pop() {
        len--;
        return arr[len];
    }
    public boolean isEmpty() {
        return len == 0;
    }


    /*
    public void push(T elem) {
        T[] tmp = (T[])new Object[arr.length + 1];
        for(int i=0; i<arr.length; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;
        arr[arr.length-1] = elem;
    }
    public T pop() {
        T ret = arr[arr.length - 1];
        T[] tmp = (T[])new Object[arr.length - 1];
        for(int i=0; i<tmp.length ; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;
        return ret;
    }
    public T peek() {
        return arr[arr.length - 1];
    }
    public boolean isEmpty() {
        return arr.length == 0;
    }
    */
}

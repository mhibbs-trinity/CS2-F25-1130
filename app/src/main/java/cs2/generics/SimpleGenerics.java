package cs2.generics;

import java.util.ArrayList;

public class SimpleGenerics {
    public static ArrayList<Integer> a2al(int[] a) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i : a) {
            al.add(i);
        }
        return al;
    }

    public static <T> ArrayList<T> a2al(T[] a) {
        ArrayList<T> al = new ArrayList<>();
        for(T i : a) {
            al.add(i);
        }
        return al;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        Double[] b = {1.2, 3.4, 5.6, 7.8};
        System.out.println(a);
        System.out.println(b);
        System.out.println(a2al(a));
        System.out.println(a2al(b));
    }

}

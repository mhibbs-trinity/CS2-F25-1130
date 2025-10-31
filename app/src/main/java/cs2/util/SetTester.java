package cs2.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTester {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<Integer>();
        System.out.println(s);
        s.add(5);
        s.add(3);
        System.out.println(s);
        System.out.println(s.size());
        System.out.println(s.isEmpty());
        System.out.println(s.contains(4));
        s.remove(3);
        System.out.println(s);
        s.add(7);
        s.add(7);
        s.add(7);
        System.out.println(s);
        s.remove(3);
        System.out.println(s);

        HashSet<Integer> s2 = new HashSet<>();
        s2.add(5);
        s2.add(9);
        s2.add(1);

        System.out.println(s);
        System.out.println(s2);
        System.out.println(s.addAll(s2));
        System.out.println(s);

        int total = 0;
        Iterator<Integer> it = s.iterator();
        while(it.hasNext()) {
            total += it.next();
        }
        System.out.println(total);


    }
}

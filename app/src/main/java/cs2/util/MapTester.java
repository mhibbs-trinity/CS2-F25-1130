package cs2.util;

import java.util.HashMap;

public class MapTester {
    public static void main(String[] args) {
        HashMap<Character, Double> m = new HashMap<>();
        System.out.println(m);
        m.put('Z', Math.PI);
        m.put('A', 0.0);
        System.out.println(m);
        m.put('C', 3.4);
        m.put('W', 14.2);
        System.out.println(m);
        m.put('A', 42.4);
        System.out.println(m);
        System.out.println(m.size());
        System.out.println(m.containsKey('B'));
        System.out.println(m.containsValue(14.2));
        System.out.println(m.remove('W'));
        System.out.println(m);
        System.out.println(m.remove('W'));
        System.out.println(m);
        m.put('W', 3.4);

        double total = 0;
        for(char key : m.keySet()) {
            System.out.println(key + " -> " + m.get(key));
            total += m.get(key);
        }
        System.out.println(total);


    }
}

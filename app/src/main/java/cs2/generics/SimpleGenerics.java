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

    public static <T extends Comparable<T>> void bubbleSort(T[] a) {
        for(int j=0; j<a.length; j++) {
            for(int i=0; i<a.length-1-j; i++) {
                if(a[i].compareTo(a[i+1]) > 0) {
                    T tmp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {5,1,7,9,2,3,4};
        Double[] b = {1.2, 8.2, 3.4, 12d, 5.6, -14.2, 7.8};

        for(int x : a) System.out.print(x + ", ");
        System.out.println();
        bubbleSort(a);
        for(int x : a) System.out.print(x + ", ");

        for(double x : b) System.out.print(x + ", ");
        System.out.println();
        bubbleSort(b);
        for(double x : b) System.out.print(x + ", ");

        Student[] s = new Student[3];
        s[0] = new Student("Sally", 4.0);
        s[1] = new Student("Bob", 1.5);
        s[2] = new Student("Alice", 3.0);

        for(Student x : s) System.out.print(x.name + ", ");
        System.out.println();
        bubbleSort(s);
        for(Student x : s) System.out.print(x.name + ", ");
    }
}
class Student implements Comparable<Student> {
    public String name;
    public double gpa;
    public Student(String n, double g) { name = n; gpa = g;}
    public int compareTo(Student other) {
        // if(this.gpa < other.gpa) return -1;
        // else if(this.gpa > other.gpa) return 1;
        // else return 0;
        return this.name.compareTo(other.name);
    }
}


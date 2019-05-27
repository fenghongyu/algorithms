package com.algorithms.datastructure.st.myString;

public class Example {
    public static void sort(Comparable[] a) {
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for(int i=0;i<a.length;i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        //测试数组元素是否有序
        for(int i=1;i<a.length;i++) {
            if(less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

}

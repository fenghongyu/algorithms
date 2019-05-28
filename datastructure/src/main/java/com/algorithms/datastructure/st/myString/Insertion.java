package com.algorithms.datastructure.st.myString;

/**
 * 插排
 */
public class Insertion extends Example{
    public static void sort(Comparable[] a) {
        int n = a.length;
        for(int i=1;i<n;i++) {
            for(int j=i;j>0;j--) {
                if(less(a[j], a[j-1])) {
                    exch(a, j, j-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[]a = {5,6,1,2,3,8,9};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

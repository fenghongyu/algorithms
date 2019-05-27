package com.algorithms.datastructure.st.myString;

public class MySelection extends Example {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for(int i=0;i<N;i++) {
            int min = i;
            for(int j=i+1;j<N;j++) {
                if(less(a[j], a[min])){
                    min = j;
                }
            }
            exch(a, i, min);

        }
    }


    public static void main(String[] args) {
        Integer[]a = {5,6,1,2,3,8,9};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}

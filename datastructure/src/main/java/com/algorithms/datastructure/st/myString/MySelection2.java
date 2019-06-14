package com.algorithms.datastructure.st.myString;

/**
 * Created on 2019-06-14
 * @author fenghongyu
 */
public class MySelection2 extends Example{

    public static void selectSort(Integer[] a) {
        for(int i=0;i<a.length;i++) {
            int min = i;
            for(int j=min+1;j<a.length;j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            Integer t = a[i];
            a[i] = a[min];
            a[min] = t;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {5,6,1,2,1,2,2,3,8,9};
        selectSort(a);
        show(a);
    }
}

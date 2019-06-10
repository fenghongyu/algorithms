package com.algorithms.datastructure.st.myString;

/**
 * Created on 2019-06-10
 * @author fenghongyu
 * 冒泡排序-降序
 */
public class BubbleSort extends Example{
    public static void main(String[] args) {
        Integer[]a = {5,6,1,2,1,2,2,3,8,9};
        bubbleSort(a);
        assert isSorted(a);
        show(a);
    }

    public static void bubbleSort(Comparable[] a) {
        int length = a.length;
        for(int i=0;i<length;i++) {
            for(int j=i+1;j<length;j++) {
                if(less(a[i], a[j])) {
                    exch(a, i, j);
                }
            }
        }
    }
}

package com.algorithms.datastructure.st.myString;

/**
 * Created on 2019-06-14
 * @author fenghongyu
 * 升序
 * 快排
 */
public class MyInsertionSort extends Example{
    // 插入排序，a 表示数组，n 表示数组大小
    public static void insertionSort(Integer[] a) {
        if(a.length == 1) {
            return;
        }

        for(int i=1;i<a.length;i++) {
            int value = a[i];
            int j = i-1;
            for(;j>=0;j--) {
                if(a[j] > value) {
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }

    public static void main(String[] args) {
        Integer[] a = {5,6,1,2,1,2,2,3,8,9};
        insertionSort(a);
        show(a);
    }
}

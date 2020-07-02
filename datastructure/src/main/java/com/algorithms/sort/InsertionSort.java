package com.algorithms.sort;

import com.algorithms.datastructure.st.myString.Example;

/**
 * Created on 2019-08-29
 * 插入排序也包含两种操作，一种是元素的比较，一种是元素移动
 * 。当我们需要将一个数据 a 插入到已排序区间时，需要拿 a 与已排序区间的元素依次比较大小，找到合适的插入位置。找到插入点之后，我们还需要将插入点之后的元素顺序往后移动一位，这样才能腾出位置给元素 a 插入。
 * @author fenghongyu
 */
public class InsertionSort extends Example {
    public static void main(String[] args) {
        Integer[] a = {7, 6, 1, 2, 1, 2, 2, 3, 8, 9};
        sort(a);
        show(a);
    }

    public static void sort(Integer[] a) {
        for(int i=1;i<a.length;i++) {
            int target = a[i];
            int j = i-1;
            for(;j>=0;j--) {
                if(a[j]>target) {
                    //2，1，1
                    Integer tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;

                } else {
                   break;
                }
            }
        }
    }

//    public static void sort(int[] a) {
//        for (int i = 1; i < a.length; i++) {
//            Integer targetValue = a[i];
//            int j = i-1;
//            for(;j>=0; j--) {
//                if(a[j] > targetValue) {
//                    //交换位置
//                    a[j+1] = a[j];
//                } else {
//                    break;
//                }
//            }
//            a[j+1] = targetValue;
//        }
//    }
}

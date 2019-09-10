package com.algorithms.sort;

import com.algorithms.datastructure.st.myString.Example;

/**
 * Created on 2019-08-29
 * 冒泡排序
 * 冒泡排序只会操作相邻的两个数据。每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。如果不满足就让它俩互换。
 * 一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
 *第一，冒泡排序是原地排序算法吗？
 * 冒泡的过程只涉及相邻数据的交换操作，只需要常量级的临时空间，所以它的空间复杂度为 O(1)，是一个原地排序算法。
 * 第二，冒泡排序是稳定的排序算法吗？
 * 在冒泡排序中，只有交换才可以改变两个元素的前后顺序。为了保证冒泡排序算法的稳定性，当有相邻的两个元素大小相等的时候，我们不做交换，相同大小的数据在排序前后不会改变顺序，所以冒泡排序是稳定的排序算法。
 * @author fenghongyu
 */
public class BubbleSort extends Example {

    public static void main(String[] args) {
        Integer[] a = {5, 6, 1, 2, 1, 2, 2, 3, 8, 9};
        sort(a);
        assert isSorted(a);
        show(a);
    }

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
//            boolean flag = false;
            for(int j=1;j<a.length; j++) {
                if(less(a[j],a[j-1])) {
                    exch(a, j, j-1);
                }
            }
        }
    }
}

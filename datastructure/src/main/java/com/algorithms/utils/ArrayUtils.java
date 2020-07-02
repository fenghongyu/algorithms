package com.algorithms.utils;

import java.util.List;

/**
 * Created on 2019-06-14
 * @author fenghongyu
 */

public class ArrayUtils {

    public static void showArray(int[] array) {
        for(int i : array) {
            System.out.print(i + ",");
        }
    }

    public static void showList(List<Integer> list) {
        for(Object o : list) {
            System.out.print(o + ",");
        }
    }


}

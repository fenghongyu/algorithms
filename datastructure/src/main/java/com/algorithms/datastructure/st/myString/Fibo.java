package com.algorithms.datastructure.st.myString;


/**
 * Created on 2019-06-10
 * @author fenghongyu
 */
public class Fibo {

    int Fibonacci(int n){
        if(n==0){
            return 0;
        }
        //先独立判断n为1和n为2的情况
        if(n==1||n==2){
            return 1;
        }
        //递归方法计算出第n个斐波拉契数
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
    public static void main(String[] args) {
        System.out.println(new Fibo().Fibonacci(7));
    }

}

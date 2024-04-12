package com.wf.dataStructure.recursion;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/15 12:35
 * @Package com.wf.dataStructure.recursion
 * @Version 1.0
 * @Since 1.0
 */

/**
 * 递归求阶乘
 */
public class Factorial01 {

    public static int f(int n){
        if(n == 1){
            return 1;
        }
        return n * f(n - 1);
    }

    public static void main(String[] args) {
        int f = f(5);
        System.out.println(f);
    }

}

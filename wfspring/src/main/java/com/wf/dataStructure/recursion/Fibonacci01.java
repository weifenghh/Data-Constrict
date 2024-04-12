package com.wf.dataStructure.recursion;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/15 12:39
 * @Package com.wf.dataStructure.recursion
 * @Version 1.0
 * @Since 1.0
 */

import java.util.Arrays;

/**
 * 斐波那契取第n项
 */
public class Fibonacci01 {

    public static int fibonacci(int n){
        int[] cache = new int[n + 1];
        Arrays.fill(cache,-1);
        cache[0] = 0;
        cache[1] = 1;
        return f(n,cache);
    }

    public static int f(int n,int[] cache){


        if(cache[n] != -1){
            return cache[n];
        }

        int x = f(n - 1 ,cache);
        int y = f(n - 2,cache);
        cache[n] =  x + y;
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(6));
    }

}

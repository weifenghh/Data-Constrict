package com.wf.dataStructure.recursion;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/17 8:41
 * @Package com.wf.dataStructure.recursion
 * @Version 1.0
 * @Since 1.0
 */
public class HanoiTower {

    static LinkedList<Integer> a = new LinkedList<>();
    static LinkedList<Integer> b = new LinkedList<>();
    static LinkedList<Integer> c = new LinkedList<>();


     static void init(int n){
        for (int i = n; i >= 1; i--) {
            a.addLast(i);
        }
    }

    static void move(int n, LinkedList<Integer> a,
                     LinkedList<Integer> b,
                     LinkedList<Integer> c){
         if(n == 0){
             return;
         }
         move(n - 1,a,c,b);
         c.addLast(a.removeLast());
        print();
         move(n - 1,b,a,c);
    }

    public static void main(String[] args) {
         int n = 4;
        init(n);
        print();
        move(n,a,b,c);
    }

    private static void print(){
        System.out.println("==============");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}

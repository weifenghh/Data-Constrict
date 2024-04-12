package com.wf.dataStructure.Leetcode.stack;

import java.util.LinkedList;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/28 9:19
 * @Package com.wf.dataStructure.Leetcode.stack
 * @Version 1.0
 * @Since 1.0
 */
public class AgainstPoland {

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "/", "*", "17", "+", "5", "+"};
        System.out.println(new AgainstPoland().againstPoland(tokens));
    }

    public int againstPoland(String[] tokens){
        LinkedList<Integer> stack = new LinkedList<>();
        for (String t : tokens){
            switch (t) {
                case "+" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    Integer b = stack.pop();
                    Integer a = stack.pop();
                    stack.push(a / b);
                }
                default -> {
                    stack.push(Integer.parseInt(t));
                }
            }
        }
        return stack.pop();
    }

}

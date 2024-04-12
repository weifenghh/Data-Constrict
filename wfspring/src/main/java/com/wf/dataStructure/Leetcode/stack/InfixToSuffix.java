package com.wf.dataStructure.Leetcode.stack;

import java.util.LinkedList;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/28 9:44
 * @Package com.wf.dataStructure.Leetcode.stack
 * @Version 1.0
 * @Since 1.0
 */
public class InfixToSuffix {

    public static void main(String[] args) {
        System.out.println(infixToSuffix("a+b"));
        System.out.println(infixToSuffix("a+b-c"));
        System.out.println(infixToSuffix("a+b*c"));
        System.out.println(infixToSuffix("a*b-c"));
        System.out.println(infixToSuffix("(a+b*c-d)*e"));
        System.out.println(infixToSuffix("a*(b+c)"));

    }

    static int priority(char c){
        return switch (c) {
            case '*','/' -> 2;
            case '+','-' -> 1;
            case '(' -> 0;
            default -> throw new IllegalArgumentException("参数错误");
        };
    }

    static String infixToSuffix(String exp){
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder(exp.length());
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '+','-','*','/' -> {
                    if(stack.isEmpty()){
                        stack.push(c);
                    }else{
                        if(priority(c) > priority(stack.peek())) {
                            stack.push(c);
                        }else {
                            while(!stack.isEmpty() && priority(c) <= priority(stack.peek())){
                                sb.append(stack.pop());
                            }
                            stack.push(c);
                        }
                    }
                }
                case '(' -> {
                    stack.push(c);
                }
                case ')' -> {
                    while(!stack.isEmpty() && stack.peek() != '('){
                        sb.append(stack.pop());
                    }
                    stack.pop();
                }
                default -> {
                    sb.append(c);
                }
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}

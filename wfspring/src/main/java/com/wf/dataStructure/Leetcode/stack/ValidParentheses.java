package com.wf.dataStructure.Leetcode.stack;

import com.wf.dataStructure.stack.ArrayStack;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/27 10:08
 * @Package com.wf.dataStructure.Leetcode.stack
 * @Version 1.0
 * @Since 1.0
 */
public class ValidParentheses {

    public boolean isValid(String s){
        ArrayStack<Character> stack = new ArrayStack<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else {
                if(!stack.isEmpty() && c == stack.peek()){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("({[]})"));
        System.out.println(validParentheses.isValid("(){}[]"));
        System.out.println(validParentheses.isValid("()"));
        System.out.println(validParentheses.isValid("{}"));
        System.out.println(validParentheses.isValid("[]"));
        System.out.println(validParentheses.isValid("(]"));
        System.out.println(validParentheses.isValid("({{]})"));
        System.out.println(validParentheses.isValid("){"));

    }

}

package com.wf.dataStructure.Leetcode.stack;

import com.wf.dataStructure.stack.ArrayStack;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/1 9:14
 * @Package com.wf.dataStructure.Leetcode.stack
 * @Version 1.0
 * @Since 1.0
 */

public class TwoStackAsQueue {

    /**
     * 双栈模拟队列
     *
            队列头       队列尾
           顶   底      底  顶
           s1              s2
     */

    ArrayStack<Integer> s1 = new ArrayStack<>(100);
    ArrayStack<Integer> s2 = new ArrayStack<>(100);

    public void push(int x){ //向队列尾部添加
        s2.push(x);
    }

    public void pop(){   //向队列头部移除
        if(s1.isEmpty()){
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        s1.pop();
    }

    public void peek(){  //从队列头获取
        if(s1.isEmpty()){
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        s1.peek();
    }

    public boolean empty(){  //队列是否为空
        return s1.isEmpty() && s2.isEmpty();
    }

}

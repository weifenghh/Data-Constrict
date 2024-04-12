package com.wf.dataStructure.stack;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/27 9:15
 * @Package com.wf.dataStructure.stack
 * @Version 1.0
 * @Since 1.0
 */
public interface Stack<E> {

    boolean push(E value);

    E pop();

    E peek();

    boolean isEmpty();

    boolean isFull();

}

package com.wf.dataStructure.queue;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/1 10:12
 * @Package com.wf.dataStructure.Leetcode.stack
 * @Version 1.0
 * @Since 1.0
 */
public interface Deque<E> {
    boolean offerFirst(E e);

    boolean offerLast(E a);

    E pollFirst();

    E pollLast();

    E peekFirst();

    E peekLast();

    boolean isEmpty();

    boolean isFull();
}

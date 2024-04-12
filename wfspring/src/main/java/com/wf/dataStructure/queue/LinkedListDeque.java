package com.wf.dataStructure.queue;

import java.util.Iterator;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/1 10:16
 * @Package com.wf.dataStructure.Leetcode.stack
 * @Version 1.0
 * @Since 1.0
 */

/**
 * 单个链表实现双端队列
 * @param <E>
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    public static void main(String[] args) {
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(10);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        deque.offerLast(5);
        deque.offerLast(6);
        for (Integer i : deque){
            System.out.println(i);
        }

    }

    int capacity;
    int size;
    Node<E> sentinel = new Node<>(null,null,null);

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public boolean offerFirst(E e) {
        if(isFull()){
            return false;
        }
        Node<E> a = sentinel;
        Node<E> b = a.next;
        Node<E> added = new Node<>(a,e,b);
        a.next = added;
        b.prev = added;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if(isFull()){
            return false;
        }
        Node<E> a = sentinel;
        Node<E> b = a.prev;
        Node<E> added = new Node<>(b, e, a);
        a.prev = added;
        b.next = added;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> a = sentinel;
        Node<E> removed = a.next;
        Node<E> c = removed.next;
        a.next = c;
        c.prev = a;
        size--;
        return removed.value;
    }

    @Override
    public E pollLast() {
        if(isEmpty()){
            return null;
        }
        Node<E> b = sentinel;
        Node<E> removed = b.prev;
        Node<E> a = removed.prev;
        a.next = b;
        b.prev = a;
        size--;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        if(isEmpty()){
            return null;
        }
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        if(isEmpty()){
            return null;
        }
        return sentinel.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    static class Node<E> {
        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next){
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

}

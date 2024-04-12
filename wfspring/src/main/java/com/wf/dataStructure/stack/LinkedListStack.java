package com.wf.dataStructure.stack;

import java.util.Iterator;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/27 9:17
 * @Package com.wf.dataStructure.stack
 * @Version 1.0
 * @Since 1.0
 */
public class LinkedListStack<E> implements Stack<E>,Iterable<E> {

    private int capacity;
    private int size;
    private Node<E> head = new Node<>(null,null);

    public LinkedListStack(int capacity){
        this.capacity = capacity;
    }

    @Override
    public boolean push(E value) {
        if(isFull()){
            return false;
        }
        Node<E> added = new Node<>(value, head.next);
        head.next = added;
        size++;
        return true;
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        Node<E> removed = head.next;
        head.next = removed.next;
        return removed.value;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        return first.value;
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
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

}

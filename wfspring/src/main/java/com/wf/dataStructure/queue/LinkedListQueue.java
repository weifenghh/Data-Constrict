package com.wf.dataStructure.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/24 9:21
 * @Package com.wf.dataStructure.queue
 * @Version 1.0
 * @Since 1.0
 */
public class LinkedListQueue<E> implements Iterable<E>, Queue<E> {

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    Node<E> head = new Node<>(null,null);
    Node<E> tail = head;

    public LinkedListQueue() {
        this.tail.next = head;
    }

    @Override
    public boolean offer(E e) {
        Node<E> added = new Node<>(e, head);
//        head.next = added;
        tail.next = added;
        tail = added;
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }



    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        if(isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        if(first == tail){
            tail = head;
        }
        return first.value;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        if(isEmpty()){
            return null;
        }
        return head.next.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());


    }

}

package com.wf.dataStructure.queue;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/2 10:50
 * @Package com.wf.dataStructure.queue
 * @Version 1.0
 * @Since 1.0
 */

import java.util.Iterator;

/**
 * 数组实现双端队列

 判断是否为空
 h
 t
 0  1  2  3
 t == h

 判断是否满了
 1.offerLast
 h
          t
 0  1  2  3
 a  b  c
 tail>head
 t - h == array.length - 1

 2.offerFirst
    h
 t
 0  1  2  3
    c  a  b
 tail < head
 head - tail == 1

 删除元素（引用类型）时，需要进行垃圾回收，可以将删除的元素置为null
 */
public class ArrayDeque<E> implements Deque<E>,Iterable<E> {

    E[] array;
    int head;
    int tail;

    public ArrayDeque(int capacity){
        array = (E[]) new Object[capacity + 1];
    }

    static int inc(int i, int length){
        if(i + 1 >= length){
            return 0;
        }
        return i + 1;
    }

    static int dec(int i, int length){
        if(i - 1 < 0){
            return length - 1;
        }
        return i - 1;
    }

    //头部添加，先减后添加
    @Override
    public boolean offerFirst(E e) {
        if(isFull()){
            return false;
        }
        head = dec(head, array.length);
        array[head] = e;
        return true;
    }

    //尾部添加，先添加后加
    @Override
    public boolean offerLast(E e) {
        if(isFull()){
            return false;
        }
        array[tail] = e;
        tail = inc(tail, array.length);
        return true;
    }

    @Override
    public E pollFirst() {
        if(isEmpty()){
            return null;
        }
        E e = array[head];
        array[head] = null;  //help GC
        head = inc(head, array.length);
        return e;
    }

    @Override
    public E pollLast() {
        if(isEmpty()){
            return null;
        }
        tail = dec(tail, array.length);
        E e = array[tail];
        array[tail] = null;  //help GC
        return e;
    }

    @Override
    public E peekFirst() {
        if(isEmpty()){
            return null;
        }
        return array[head];
    }

    @Override
    public E peekLast() {
         if(isEmpty()){
             return null;
         }
        return array[tail - 1];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        if(tail > head){
            return tail - head == array.length - 1;
        }else if(head > tail){
            return head - tail == 1;
        }else{
            return false;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public E next() {
                E e = array[p];
                p = inc(p,array.length);
                return e;
            }
        };
    }
}

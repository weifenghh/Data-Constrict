package com.wf.dataStructure.queue;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/6 9:44
 * @Package com.wf.dataStructure.queue
 * @Version 1.0
 * @Since 1.0
 */
public class BlackingQueue2<E> implements BlackingQueue<E> {

    private final E[] array;
    private int head;
    private int tail;
    private AtomicInteger size;    //由于size不是一个原子型操作

    public BlackingQueue2(int capacity){
        array = (E[]) new Object[capacity];
    }

    private ReentrantLock headLock = new ReentrantLock();
    Condition headWait = headLock.newCondition();
    private ReentrantLock tailLock = new ReentrantLock();
    Condition tailWait = tailLock.newCondition();

    private boolean isEmpty(){
        return size.get() == 0;
    }
    private boolean isFull(){
        return size.get() == array.length;
    }

    @Override
    public void offer(E e) throws InterruptedException {
        int c;
        tailLock.lockInterruptibly();
        try{
            while(isFull()){
                tailWait.await();
            }
            array[tail] = e;
            if(++tail >= array.length){
                tail = 0;
            }
            c = size.getAndIncrement();
            if(c + 1 < array.length){
                tailWait.signal();
            }
        }finally{
            tailLock.unlock();
        }

        //配对使用
        if(c == 0){
            headLock.lock();
            try{
                headWait.signal();
            }finally{
                headLock.unlock();
            }
        }

    }

    @Override
    public boolean offer(E e, long timeOut) throws InterruptedException {
        return false;
    }

    @Override
    public E pool() throws InterruptedException {
        E e;
        int c;
        headLock.lockInterruptibly();
        try{
            while(isEmpty()){
                headWait.await();
            }
            e = array[head];
            if(++head >= array.length){
                head = 0;
            }
            c = size.getAndDecrement();
            if(c > 1){
                headWait.signal();
            }
        }finally{
            headLock.unlock();
        }

        if(c == array.length){
            tailLock.lock();
            try {
                tailWait.signal();
            } finally {
                tailLock.unlock();
            }
        }
        return e;
    }
}

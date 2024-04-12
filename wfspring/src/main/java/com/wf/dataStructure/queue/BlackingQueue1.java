package com.wf.dataStructure.queue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/5 9:41
 * @Package com.wf.dataStructure.queue
 * @Version 1.0
 * @Since 1.0
 */

/**
 * 单锁阻塞队列
 * @param <E>
 */
public class BlackingQueue1<E> implements BlackingQueue<E>{

    private final E[] array;
    private int head;
    private int tail;
    private int size;

    public BlackingQueue1(int capacity){
        array = (E[]) new Object[capacity];
    }

    //可重入锁
    private ReentrantLock lock = new ReentrantLock();
    //入队等待（房间）
    private Condition offerWait = lock.newCondition();
    //出队等待（房间）
    private Condition poolWait = lock.newCondition();

    private Boolean isEmpty(){
        return size == 0;
    }

    private Boolean isFull(){
        return size == array.length;
    }


    @Override
    public void offer(E e) throws InterruptedException {
        lock.lockInterruptibly();  //加锁，可打断
        try {
            //while  防止虚假唤醒  唤醒时再次进行判断
            while(isFull()){
                offerWait.await();
            }
            //唤醒后，获得到锁，进行添加操作
            array[tail] = e;
            if(++tail > array.length){
                tail = 0;
            }
            size++;
            //队列中有数据，唤醒poolWait中等待的线程，进行消费
            poolWait.signal();
        }finally{
            lock.unlock();
        }
    }

    @Override
    public boolean offer(E e, long timeOut) throws InterruptedException {
        lock.lockInterruptibly();  //加锁，可打断
        try {
            long NanoTime = TimeUnit.MILLISECONDS.toNanos(timeOut);
            //while  防止虚假唤醒  唤醒时再次进行判断
            while(isFull()){
                if(NanoTime <= 0){
                    return false;
                }
                NanoTime = offerWait.awaitNanos(NanoTime);  //返回剩余等待时间
            }
            //唤醒后，获得到锁，进行添加操作
            array[tail] = e;
            if(++tail > array.length){
                tail = 0;
            }
            size++;
            //队列中有数据，唤醒poolWait中等待的线程，进行消费
            poolWait.signal();
            return true;
        }finally{
            lock.unlock();
        }
    }

    @Override
    public E pool() throws InterruptedException {
        lock.lockInterruptibly();
        while(isEmpty()){
            poolWait.await();
        }
        try{
            E e = array[head];
            array[head] = null;  //help GC
            if(++head > array.length){
                head = 0;
            }
            size--;
            offerWait.signal();
            return e;
        }finally{
            lock.unlock();
        }

    }
}

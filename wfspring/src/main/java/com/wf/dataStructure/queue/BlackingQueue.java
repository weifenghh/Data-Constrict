package com.wf.dataStructure.queue;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/5 9:34
 * @Package com.wf.dataStructure.queue
 * @Version 1.0
 * @Since 1.0
 */

/**
 * 阻塞队列接口
 * 用锁保证线程安全
 * 使用条件变量让offer pool线程进行等待，而不是让线程进行不断循环尝试，导致CPU空转
 * @param <E>
 */
public interface BlackingQueue<E> {

    void offer(E e) throws InterruptedException;
    boolean offer(E e,long timeOut) throws InterruptedException;
    E pool() throws InterruptedException;

}

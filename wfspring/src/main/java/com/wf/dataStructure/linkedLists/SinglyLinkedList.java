package com.wf.dataStructure.linkedLists;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/12 13:33
 * @Package com.wf.dataStructure.linkedLists
 * @Version 1.0
 * @Since 1.0
 */
public class SinglyLinkedList implements Iterable<Integer>{

    private Node head = new Node(666,null);

    private static class Node{
        int value; //值
        Node next; //下一个指针节点

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * addFirst: 从头添加节点(头插法)
     * @param value
     */
    public void addFirst(int value){
        //链表为空
//        head = new Node(value,null);
        //链表非空
//        head.next = new Node(value,head.next);
        insert(0,value);
    }

    /**
     * findLast：寻找对最后一个节点
     * @return
     */
    private Node findLast(){
        //添加哨兵，就不可能为空
//        if(head == null){
//            return null;
//        }
        Node p;
        for(p = head; p.next != null; p = p.next){

        }
        return p;
    }

    /**
     * addLast：尾插法
     * @param value
     */
    public void addLast(int value){
        Node last = findLast();
        //添加哨兵，就不可能为空
//        if(last == null){
//            addFirst(value);
//            return;
//        }
        last.next = new Node(value,null);
    }

    /**
     * findNode: 查找节点
     * @param index
     * @return
     */
    private Node findNode(int index){
        int i = -1;
        for (Node p = head; p != null; p = p.next,i++) {
            if(i == index){
                return p;
            }
        }
        return null;
    }

    /**
     * get: 通过索引获取节点值
     * @param index
     * @return
     */
    public int get(int index) {
        Node node = findNode(index);
        if(node == null){
            throw new IllegalArgumentException(String.format("index [%d] 越界",index));
        }
        return node.value;
    }

    /**
     * insert: 指定位置插入
     * @param index
     * @param value
     */
    public void insert(int index, int value){
        Node prev = findNode(index - 1);
        if(prev == null){
            throw new IllegalArgumentException(String.format("index [%d] 越界", index));
        }
        prev.next = new Node(value,prev.next);
    }

    /**
     * removeFirst: 删除第一个节点
     */
    public void removeFirst(){
//        if(head == null){
//            throw new IllegalArgumentException("链表为空");
//        }
//        head = head.next;
        remove(0);
    }

    /**
     * remove: 删除节点
     */
    public void remove(int index){
        Node prev = findNode(index - 1);
//        if(prev == null){
//            throw new IllegalArgumentException(String.format("index [%d] 越界", index));
//        }
        Node current =prev.next;
//        if(current == null){
//            throw new IllegalArgumentException(String.format("index [%d] 越界", index));
//        }
        prev.next = current.next;

    }

    /**
     * loop: 遍历链表
     * @param consumer
     */
    public void loop(Consumer<Integer> consumer){
        Node p = head;
        while(p != null){
            consumer.accept(p.value);
            p = p.next;
        }
    }

    public void loop1(Consumer<Integer> consumer){
        for (Node p = head; p != null; p = p.next){
            consumer.accept(p.value);
        }
    }

    /**
     * 递归遍历
     */
    public void loop2(Consumer<Integer> before, Consumer<Integer> after){
        recursion(head,before,after);
    }
    private void recursion(Node current,Consumer<Integer> before, Consumer<Integer> after){
        if(current == null){
            return;
        }
        before.accept(current.value);
        recursion(current.next,before,after);
        after.accept(current.value);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;
            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

}



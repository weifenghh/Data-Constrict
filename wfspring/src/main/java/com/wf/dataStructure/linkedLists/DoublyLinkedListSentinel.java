package com.wf.dataStructure.linkedLists;

import java.util.Iterator;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/13 14:58
 * @Package com.wf.dataStructure.linkedLists
 * @Version 1.0
 * @Since 1.0
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {

    static class Node{
        Node prev;  //前指针
        int value;
        Node next;  //后指针

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;  //头哨兵
    private Node tail;  //尾哨兵

    public DoublyLinkedListSentinel(){
        head = new Node(null,666,null);
        tail = new Node(null,999,null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 根据索引找到对应节点
     * @param index
     * @return
     */
    private Node findNode(int index){
        int i = -1;
        for (Node p = head; p != tail; p = p.next,i++){
            if(i == index){
                return p;
            }
        }
        return null;
    }

    public void addFirst(int value){
        insert(0,value);
    }

    public void removeFirst(){
        remove(0);
    }

    /**
     * 添加节点到最后
     * @param value
     */
    public void addLast(int value){
        Node prev = tail.prev;
        Node insert = new Node(prev, value, tail);
        prev.next = insert;
        tail.prev = insert;
    }

    public void removeLast(){
        Node removed = tail.prev;
        Node prev = removed.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    /**
     * 指定位置插入节点
     * @param index
     * @param value
     */
    public void insert(int index,int value){
        Node prev = findNode(index - 1);
        if(prev == null){
            throw new IllegalArgumentException(String.format("index[%d] 越界",index));
        }
        Node next = prev.next;
        Node current = new Node(prev, value, next);
        prev.next = current;
        next.prev = current;
    }

    /**
     * 分局索引删除节点
     * @param index
     */
    public void remove(int index){
        Node prev = findNode(index - 1);
        if(prev == null){
            throw new IllegalArgumentException(String.format("index[%d] 越界",index));
        }
        Node removed = prev.next;
        if(removed == tail){
            throw new IllegalArgumentException(String.format("index[%d] 越界",index));
        }
        Node next = removed.next;

        prev.next = next;
        next.prev = prev;
    }

    public void get(int index){
        Node node = findNode(index);
        System.out.println(node.value);
    }

    /**
     * 迭代器 增强for循环遍历双向链表
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
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

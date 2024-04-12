package com.wf.dataStructure.linkedLists;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/12 13:48
 * @Package com.wf.dataStructure.linkedLists
 * @Version 1.0
 * @Since 1.0
 */
public class test {

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);

        list.insert(0,1);

        list.loop(value -> {
            System.out.println(value);
        });

        list.removeFirst();
        list.remove(4);
        System.out.println("================");

        for (Integer value : list){
            System.out.println(value);
        }

        list.loop2(value -> {
            System.out.println("(before)" + value);
        },value -> {
            System.out.println("(after)" + value);
        });

        System.out.println("=========get==========");
        System.out.println(list.get(2));
    }



}

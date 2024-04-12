package com.wf.dataStructure.linkedLists;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/13 14:58
 * @Package com.wf.dataStructure.linkedLists
 * @Version 1.0
 * @Since 1.0
 */
public class test02 {

    public static void main(String[] args) {
        DoublyLinkedListSentinel list = new DoublyLinkedListSentinel();
        list.addFirst(9);
        list.addFirst(8);
        list.addFirst(7);
        list.insert(0,6);

        list.remove(0);
//        list.get(0);
        for(int value : list){
            System.out.println(value);
        }
    }

}

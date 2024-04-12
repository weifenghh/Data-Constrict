package com.wf.dataStructure.Leetcode;

import java.util.HashMap;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/18 8:56
 * @Package com.wf.dataStructure.Leetcode
 * @Version 1.0
 * @Since 1.0
 */
public class ReverseSingleLinkedList {


    public static class ListNode{
        private int value;
        private ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("[");
            ListNode p = this;
            while(p != null){
                sb.append(p.value);
                if(p.next != null){
                    sb.append(",");
                }
                p = p.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

    static  class List{
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first){
            first.next = head;
            head = first;
        }

        public ListNode removeFirst(){
            ListNode removeFirst = head;
            if(removeFirst != null){
                head = removeFirst.next;
            }
            return removeFirst;
        }
    }

    public static ListNode reverseList4(ListNode o1){
        ListNode n1 = null;
         while(o1 != null){
             ListNode o2 = o1.next;
             o1.next = n1;
             n1 = o1;
             o1 = o2;
         }
         return n1;
    }

    public static ListNode reverseList3(ListNode o1){
        if(o1 == null || o1.next == null){
            return o1;
        }
        ListNode o2 = o1.next;
        ListNode n1 = o1;
        while(o2 != null){
            o1.next = o2.next;
            o2.next = n1;
            n1 = o2;
            o2 = o1.next;
        }
        return n1;
    }

    public static ListNode reverseList2(ListNode p){
        if(p == null || p.next == null) {
            return p;
        }
        ListNode lastListNode = reverseList2(p.next);
        p.next.next = p;
        p.next = null;
        return lastListNode;
    }

    public static ListNode reverseList1(ListNode head){
        List oldList = new List(head);
        List newList = new List(null);

        while (true){
            ListNode removeNode = oldList.removeFirst();
            if(removeNode == null){
                break;
            }
            newList.addFirst(removeNode);
        }

        return newList.head;
    }

    public static ListNode reverseList(ListNode o1){
        if(o1 == null || o1.next == null){
            return o1;
        }
        ListNode n1 = null;
        ListNode p = o1;
        while(p != null){
            n1 = new ListNode(p.value,n1);
            p = p.next;
        }
        return n1;
    }


    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode reverseList = reverseList4(o1);
        System.out.println(reverseList);
    }

}

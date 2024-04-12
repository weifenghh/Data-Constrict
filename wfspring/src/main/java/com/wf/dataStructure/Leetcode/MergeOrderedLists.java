package com.wf.dataStructure.Leetcode;

import java.sql.Array;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/21 8:54
 * @Package com.wf.dataStructure.Leetcode
 * @Version 1.0
 * @Since 1.0
 */
public class MergeOrderedLists {

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

    /**
     * 合并有序链表（两个）
     * @param p1
     * @param p2
     * @return
     */
    public static ListNode mergerOrderedLists(ListNode p1,ListNode p2){
        ListNode s = new ListNode(-1,null);
        ListNode p = s;
        while(p1 != null && p2 != null){
            if(p1.value > p2.value){
                p.next = p2;
                p2 = p2.next;
            }else{
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if(p1 != null){
            p.next = p1;
        }
        if(p2 != null){
            p.next = p2;
        }
        return s.next;
    }

    public static ListNode mergerOrderedLists1(ListNode p1,ListNode p2){
        if(p1 == null){
            return p2;
        }
        if(p2 == null){
            return p1;
        }
        if(p1.value < p2.value){
            p1.next = mergerOrderedLists1(p1.next,p2);
            return p1;
        }else{
            p2.next = mergerOrderedLists1(p1,p2.next);
            return p2;
        }
    }

    /**
     * 合并有序链表（k个）
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0){
            return null;
        }
        return split(lists, 0, lists.length - 1);
    }

    private ListNode split(ListNode[] lists,int i, int j){
        if(i == j){
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode left = split(lists, i, m);
        ListNode right = split(lists, m + 1, j);
        return mergerOrderedLists(left,right);
    }

    /**
     * 查找链表中间值
     * @param head
     */
    public static ListNode middleNode(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(10, null);
        ListNode o4 = new ListNode(9, o5);
        ListNode o3 = new ListNode(6, o4);
        ListNode o2 = new ListNode(5, o3);
        ListNode o1 = new ListNode(3, o2);

        ListNode a5 = new ListNode(8, null);
        ListNode a4 = new ListNode(7, a5);
        ListNode a3 = new ListNode(4, a4);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(1, a2);

        ListNode b5 = new ListNode(8, null);
        ListNode b4 = new ListNode(7, b5);
        ListNode b3 = new ListNode(4, b4);
        ListNode b2 = new ListNode(2, b3);
        ListNode b1 = new ListNode(1, b2);

//        ListNode[] lists = new ListNode[]{
//                a1,o1,b1
//        };
//        ListNode listNode = new MergeOrderedLists().mergeKLists(lists);
//        System.out.println(listNode);

//        ListNode listNode = mergerOrderedLists1(o1, a1);

        ListNode listNode = middleNode(o1);
        System.out.println(listNode);
    }

}

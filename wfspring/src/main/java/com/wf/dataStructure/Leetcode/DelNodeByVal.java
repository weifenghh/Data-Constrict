package com.wf.dataStructure.Leetcode;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/19 9:25
 * @Package com.wf.dataStructure.Leetcode
 * @Version 1.0
 * @Since 1.0
 */
public class DelNodeByVal {

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

    public static ListNode removeElements(ListNode head, int val){
        //哨兵节点
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2 = s.next;
        while(p2 != null){
            if(p2.value == val){
                 p1.next = p2.next;
                 p2 = p2.next;
            }else{
                p1 =  p1.next;
                p2 =  p2.next;
            }
        }
        return s.next;
    }

    public static ListNode removeElements1(ListNode p, int value){
        if(p == null){
            return null;
        }
        if(p.value == value){
            return removeElements1(p.next,value);
        }else {
            p.next = removeElements1(p.next,value);
            return p;
        }
    }

    /**
     * 删除倒数节点
     * @param p
     * @param n
     * @return
     */
    public static ListNode removeElements2(ListNode p, int n){
        ListNode s = new ListNode(-1,p);
        recursion(s,n);
        return s.next;
    }
    public static int recursion(ListNode p, int n){
        if(p == null){
            return 0;
        }
        int nth = recursion(p.next,n);
        System.out.println(p.value + " " + nth);
        if(nth == n){
            p.next = p.next.next;
        }
        return nth + 1;
    }

    public static ListNode removeElements3(ListNode head, int n){
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }

    /**
     * 有序链表删除重复元素(留一个)
     * @param  head
     */
    public static ListNode removeElements4(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2;
        while((p2 = p1.next) != null){
            if(p1.value == p2.value){
                p1.next = p2.next;
            }else{
                p1 = p1.next;
            }
        }
        return head;
    }

    public static ListNode removeElements5(ListNode p){
        if(p == null || p.next == null){
            return p;
        }
        if(p.value == p.next.value){
            return removeElements5(p.next);
        }else{
            p.next = removeElements5(p.next);
            return p;
        }
    }

    /**
     * 有序列表删除重复元素（一个不留）
     * @param p
     */
    public static ListNode removeElements6(ListNode p){
        if(p == null || p.next == null){
            return p;
        }
        if(p.value == p.next.value){
            ListNode x = p.next.next;
            while(x != null && x.value == p.value){
                x = x.next;
            }
            return removeElements6(x);
        }
        p.next = removeElements6(p.next);
        return p;
    }

    public static ListNode removeElements7(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2,p3;
        while((p2 = p1.next) != null && (p3 = p2.next) != null){
            if(p2.value == p3.value){
                while((p3 = p3.next) != null && p3.value == p2.value){

                }
                p1.next = p3;
            }else {
                p1 = p1.next;
            }
        }
        return s.next;
    }


    public static void main(String[] args) {
        ListNode o5 = new ListNode(3, null);
        ListNode o4 = new ListNode(6, o5);
        ListNode o3 = new ListNode(6, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);
        ListNode s = removeElements7(o1);
        System.out.println(s);
    }


}

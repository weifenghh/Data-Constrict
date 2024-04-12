package com.wf.dataStructure.Leetcode;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/22 9:18
 * @Package com.wf.dataStructure.Leetcode
 * @Version 1.0
 * @Since 1.0
 */

/**
 * 判断回文子串
 * 1221
 * 12321
 * 第一步：取中间值
 * 第二步：后半部分链表进行翻转
 * 第三步：判断前半部分链表和后半部分翻转后的链表是否一致
 */
public class PalindromicSubstrings {

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

    public boolean isPalindromic1(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode n1 = null;
        ListNode o1 = head;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;

//            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }
        System.out.println(n1);
        System.out.println(p1);

        if(p2 != null){
            p1 = p1.next;
        }
        while(n1 != null){
            if(n1.value != p1.value){
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }

    public boolean isPalindromic(ListNode head){
        ListNode middle = middle(head);
        System.out.println(middle);
        ListNode newList = reverse(middle);
        System.out.println(newList);
        while(newList != null){
            if(newList.value != head.value){
                return false;
            }
            newList = newList.next;
            head = head.next;
        }
        return true;
    }

    /**
     * 第一步获取后半部分链表
     * @param head
     * @return
     */
    private ListNode middle(ListNode head){
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    /**
     * 第二步：翻转后半部分链表
     * @param o1
     * @return
     */
    private ListNode reverse(ListNode o1){
        //定义一个新链表
        ListNode n1 = null;
        while(o1 != null){
            ListNode o2 = o1.next;
            //翻转
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(1, null);
        ListNode o4 = new ListNode(2, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        PalindromicSubstrings ps = new PalindromicSubstrings();
        boolean palindromic = ps.isPalindromic1(o1);
        System.out.println(palindromic);
    }

}

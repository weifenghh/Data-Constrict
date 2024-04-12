package com.wf.dataStructure.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * @Author 玉米排骨汤
 * @Date 2024/1/26 9:50
 * @Package com.wf.dataStructure.queue
 * @Version 1.0
 * @Since 1.0
 */
public class BinaryTreeQueue<E> implements Queue<E>,Iterable<E> {

    private static class TreeNode<E>{
        private TreeNode<E> treeNode1;
        private int value;
        private TreeNode<E> treeNode2;
        public TreeNode(TreeNode<E> treeNode1,int value,TreeNode<E> treeNode2){
            this.treeNode1 = treeNode1;
            this.value = value;
            this.treeNode2 = treeNode2;
        }
        public TreeNode(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(
                        new TreeNode(5),
                        3,
                        new TreeNode(6)
                ),
                2,
                new TreeNode(
                        new TreeNode(7),
                        4,
                        new TreeNode(8)
                )
        );
        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
        queue.offer(root);
        int c1 = 1;
        while(!queue.isEmpty()){
            int c2 = 0;
            for (int i = 0; i < c1; i++) {
                TreeNode n = queue.poll();
                System.out.print(n + "");
                if(n.treeNode1 != null){
                    queue.offer(n.treeNode1);
                    c2++;
                }
                if(n.treeNode2 != null){
                    queue.offer(n.treeNode2);
                    c2++;
                }
            }
            System.out.println();
            c1 = c2;
        }
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}

package com.wf.dataStructure.binarysearchtree;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/15 8:53
 * @Package com.wf.dataStructure.binarysearchtree
 * @Version 1.0
 * @Since 1.0
 */

/**
 * 二叉搜索树
 */
public class BSTTree<K extends Comparable<K>,V> {

    BSTNode<K,V> root;

    static class BSTNode<K,V>{
        K key;
        V value;
        BSTNode<K,V> left;
        BSTNode<K,V> right;
        public BSTNode(K key) {
            this.key = key;
        }

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(K key, V value, BSTNode<K,V> left, BSTNode<K,V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public V get(K key){
        if(key == null){
            return null;
        }
        return doGet(root,key);
    }
    private V doGet(BSTNode<K,V> node, K key){
        if(node == null){
            return null;
        }
        int result = key.compareTo(node.key);
        if(result < 0){
            return doGet(node.left,key);
        }else if(result > 0){
            return doGet(node.right,key);
        }else{
            return node.value;
        }
    }

    public V min(){
        return doMin(root);
    }
    private V doMin(BSTNode<K,V> node){
        if(node == null){
            return null;
        }
        if(node.left == null){
            return node.value;
        }
        return doMin(node.left);

    }

    public V max(){
        if(root == null){
            return null;
        }
        BSTNode<K,V> p = root;
        while(p.right != null){
            p = p.right;
        }
        return p.value;
    }

    public void put(K key, Object value){

    }

    public V successor(K key){
        return null;
    }

    public V predecessor(K key){
        return null;
    }

    public V delete(K key){
        return null;
    }


}

package com.wf.dataStructure.binarysearchtree;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/15 9:11
 * @Package com.wf.dataStructure.binarysearchtree
 * @Version 1.0
 * @Since 1.0
 */
public class TestBSTTree {

    public static void main(String[] args) {
        BSTTree<String,String> tree = createTree();
//        System.out.println(tree.get("a"));
//        System.out.println(tree.get("b"));
//        System.out.println(tree.get("c"));
//        System.out.println(tree.get("d"));

        System.out.println(tree.min());
        System.out.println(tree.max());
    }

    private static BSTTree<String,String> createTree() {
        BSTTree.BSTNode<String,String> n1 = new BSTTree.BSTNode<>("a", "jack");
        BSTTree.BSTNode<String,String> n3 = new BSTTree.BSTNode<>("c", "tom");
        BSTTree.BSTNode<String,String> n2 = new BSTTree.BSTNode<>("b", "lucy",n1,n3);

        BSTTree.BSTNode<String,String> n5 = new BSTTree.BSTNode<>("e", "han");
        BSTTree.BSTNode<String,String> n7 = new BSTTree.BSTNode<>("g", "kang");
        BSTTree.BSTNode<String,String> n6 = new BSTTree.BSTNode<>("f", "lucy",n5,n7);

        BSTTree.BSTNode<String,String> root = new BSTTree.BSTNode<>("d", "lucy",n2,n6);

        BSTTree<String,String> bstTree = new BSTTree<>();
        bstTree.root = root;
        return bstTree;
    }


}

package com.wf.dataStructure.tree;

import com.sun.source.tree.Tree;
import com.wf.dataStructure.stack.LinkedListStack;

import javax.swing.tree.TreeModel;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/12 8:10
 * @Package com.wf.dataStructure.tree
 * @Version 1.0
 * @Since 1.0
 */

/**
 * 二叉树：前序遍历  中序遍历  后序遍历
 */
public class TreeTraversal {

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             /   / \
            4   5   6
         */

        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(null,4,null),2,new TreeNode(null,7,null)),
                1,
                new TreeNode(new TreeNode(null,5,null),3,new TreeNode(null,6,null))
        );
//        preOrder(root);
//        System.out.println();
//        inOrder(root);
//        System.out.println( );
//        postOrder(root);

        LinkedListStack<TreeNode> stack = new LinkedListStack<TreeNode>(16);
        TreeNode curr = root;
        TreeNode pop = null;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                System.out.println("去：" + curr.val);
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode peek = stack.peek();
                if(peek.right == null || peek.right == pop){
                    pop = stack.pop();
                    System.out.println("回：" + pop);
                }else{
                    curr = peek.right;
                }

            }
        }

    }

    //前序遍历
    static void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.val + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    static void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.val + "\t");
        inOrder(node.right);
    }

    //后序遍历
    static void postOrder(TreeNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + "\t");
    }

}

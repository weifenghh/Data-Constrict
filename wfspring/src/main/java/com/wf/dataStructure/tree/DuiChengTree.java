package com.wf.dataStructure.tree;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/13 9:16
 * @Package com.wf.dataStructure.tree
 * @Version 1.0
 * @Since 1.0
 */

/**
 * 对称二叉树
 */
public class DuiChengTree {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                new TreeNode(new TreeNode(3), 2, new TreeNode(4)),
                1,
                new TreeNode(new TreeNode(4), 2, new TreeNode(3))
        );
        boolean check = check(treeNode.left, treeNode.right);
        System.out.println(check);
    }

    public static boolean check(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(right == null || left == null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }
        return check(left.left,right.right) && check(left.right,right.left);
    }

}

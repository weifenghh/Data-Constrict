package com.wf.dataStructure.tree;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/12 8:07
 * @Package com.wf.dataStructure.tree
 * @Version 1.0
 * @Since 1.0
 */

/**
 * 树节点类
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val){
        this.val = val;
    }

    public TreeNode(TreeNode left, int val, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}

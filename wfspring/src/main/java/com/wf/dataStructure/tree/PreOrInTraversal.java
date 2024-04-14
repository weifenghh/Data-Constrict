package com.wf.dataStructure.tree;

import java.util.Arrays;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/14 9:57
 * @Package com.wf.dataStructure.tree
 * @Version 1.0
 * @Since 1.0
 */
public class PreOrInTraversal {

//    public class TreeNode {
//
//        public String val;
//        public com.wf.dataStructure.tree.TreeNode left;
//        public com.wf.dataStructure.tree.TreeNode right;
//
//        public TreeNode(String val){
//            this.val = val;
//        }
//
//        public TreeNode(com.wf.dataStructure.tree.TreeNode left, String val, com.wf.dataStructure.tree.TreeNode right) {
//            this.val = val;
//            this.left = left;
//            this.right = right;
//        }
//
//        @Override
//        public String toString() {
//            return String.valueOf(this.val);
//        }
//    }


    public TreeNode buildTree(int[] preOrder, int[] inOrder){
        if(preOrder.length == 0 || inOrder.length == 0){
            return null;
        }

        int rootValue = preOrder[0];
        TreeNode root = new TreeNode(rootValue);
        //区分左右子树
        for(int i = 0; i < inOrder.length; i++){
            if(inOrder[i] == rootValue){
                // 0 ~ i - 1  左子树
                // i+ 1 ~ inOrder.length - 1 右子树
                int[] inLeft = Arrays.copyOfRange(inOrder, 0, i);
                int[] inRight = Arrays.copyOfRange(inOrder, i + 1, inOrder.length);

                int[] preLeft = Arrays.copyOfRange(preOrder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preOrder, i + 1, preOrder.length);

                root.left = buildTree(preLeft,inLeft);
                root.right = buildTree(preRight,inRight);
                break;
            }
        }
        return root;
    }

}

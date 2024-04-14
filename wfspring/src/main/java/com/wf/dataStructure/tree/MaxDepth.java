package com.wf.dataStructure.tree;

/**
 * @Author 玉米排骨汤
 * @Date 2024/4/13 9:38
 * @Package com.wf.dataStructure.tree
 * @Version 1.0
 * @Since 1.0
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最大深度
 */
public class MaxDepth {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                new TreeNode(new TreeNode(3), 2, new TreeNode(4)),
                1,
                new TreeNode(new TreeNode(4), 2, new TreeNode(3))
        );
        int count = maxDepth2(treeNode);
        System.out.println(count);
    }

    public static int maxDepth2(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                System.out.print(poll.val + "\t");
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
            System.out.println();
            depth++;
        }
        return depth;
    }


    public static int maxDepth1(TreeNode node){
        TreeNode curr = node;
        TreeNode pop = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int max = 0;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                int size = stack.size();
                if(size > max){
                    max = size;
                }
                curr = curr.left;
            }else{
                TreeNode peek = stack.peek();
                if(peek.right == null || peek.right == pop){
                    pop = stack.pop();
                } else{
                    curr = peek.right;
                }
            }
        }
        return max;
    }

    public static int maxDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return 1;
        }
        int d1 = maxDepth(node.left);
        int d2 = maxDepth(node.right);
        return Integer.max(d1,d2) + 1;
    }

}

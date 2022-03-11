package com.dyh.algorithms4.leetcode;

import java.util.*;

/**
 * @author: dengyunhui
 * @datetime: 2022/3/9 下午9:50
 * @description:
 */
public class BinaryTreeZigzagLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()){
            Deque<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < nodeQueue.size(); i++) {
                TreeNode curNode = nodeQueue.poll();

                if (isOrderLeft){
                    levelList.offerLast(curNode.val);
                }else {
                    levelList.offerFirst(curNode.val);
                }

                if (curNode.left != null){
                    nodeQueue.offer(curNode.left);
                }

                if (curNode.right != null){
                    nodeQueue.offer(curNode.right);
                }
            }

            result.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return result;
    }

}

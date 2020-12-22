package xyz.xionglei.year2020.december.day1222;

import xyz.xionglei.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrderReference(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        // 每一层的顺序
        boolean isOrderLeft = true;
        // 辅助队列
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        nodeQueue.offer(null);
        Deque<Integer> levelList = new LinkedList<>();
        while (!nodeQueue.isEmpty()) {
            TreeNode curNode = nodeQueue.poll();
            if (curNode != null) {
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            } else {
                // 为空表示为一行结束
                res.add(new LinkedList<>(levelList));
                isOrderLeft = !isOrderLeft;
                levelList.clear();
                if (nodeQueue.size() > 0) {
                    // 表示节点队列中还存在有效值
                    nodeQueue.offer(null);
                }
            }

        }

        return res;
    }
}
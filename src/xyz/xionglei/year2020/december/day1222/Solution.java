package xyz.xionglei.year2020.december.day1222;

import xyz.xionglei.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeUtils {
 * int val;
 * TreeUtils left;
 * TreeUtils right;
 * TreeUtils(int x) { val = x; }
 * }
 */
class Solution {
    // BFS time: O(n) space: o(n)
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

    public List<List<Integer>> zigzagLevelOrderReference2(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) return ans;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            // 和上个方法相比这个方法用size来获取一行데分割，是标志的BFS写法
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
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
            }
            ans.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
}
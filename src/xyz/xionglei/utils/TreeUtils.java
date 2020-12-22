package xyz.xionglei.utils;

import java.util.Deque;
import java.util.LinkedList;

public class TreeUtils {

    public static TreeNode createBinaryTreeFormArray(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(arr[0]);
        deque.addLast(root);
        int i = 1;
        int index = 1;
        while (!(Math.pow(2, i) > arr.length)) {
            for (int j = 0; j < Math.pow(2, i) && index < arr.length; j++) {
//                TreeUtils node = new TreeUtils(arr[index++]);
                TreeNode node = (arr[index] == null ? null : new TreeNode(arr[index]));
                deque.addLast(node);
                if ((j & 1) == 0) {
                    deque.getFirst().left = node;
                } else {
                    deque.removeFirst().right = node;
                }
                index++;
            }
            i++;
        }
        return root;
    }

    public static void printBFS(TreeNode root) {

        if (root == null) return;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.removeFirst();
            System.out.print(node.val);
            if (node.left != null) {
                deque.addLast(node.left);
            }
            if (node.right != null) {
                deque.addLast(node.right);
            }
        }
        System.out.println();
    }
}

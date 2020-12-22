/**
 * Definition for a binary tree node.
 * function TreeUtils(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
import {TreeNode} from "../../../utils/TreeUtils";

/**
 * @param {TreeUtils} root
 * @return {number[][]}
 */
const zigzagLevelOrder = function(root) {
    let res =  [];
    if (root == null) return res;
    let nodeQue = [];
    nodeQue.unshift(root);
    let isOrderLeft = true;
    while (nodeQue.length > 0) {
        let size = nodeQue.length;
        let deQueList = [];
        for (let i = 0; i < size; i++) {
            let node = nodeQue.pop();
            if (isOrderLeft) {
                deQueList.push(node.val);
            } else {
                deQueList.unshift(node.val);
            }
            if (node.left != null) {
                nodeQue.unshift(node.left);
            }
            if (node.right != null) {
                nodeQue.unshift(node.right);
            }
        }
        isOrderLeft = !isOrderLeft;
        res.push(new Array(deQueList));
    }
    return res;
};


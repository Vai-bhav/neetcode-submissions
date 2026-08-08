/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode temp = root;

        while(true) {
            if (temp != null && (temp.val >= p.val && temp.val <= q.val) || (temp.val >= q.val && temp.val <= p.val)) return temp;

            if (temp.val > p.val && temp.val > q.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
    }
}

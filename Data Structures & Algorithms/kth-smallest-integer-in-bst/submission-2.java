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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode res = dfs(root, k);

        return (res == null) ? 0 : res.val;
    }

    private TreeNode dfs(TreeNode root, int k) {
        if (root == null) return null;

        TreeNode left = dfs(root.left, k);
        if (left != null) return left;
        count++;

        if (count == k) return root;

        return dfs(root.right, k);
    }
}

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
    int preorderIndex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0;i<inorder.length;i++) map.put(inorder[i], i);

        preorderIndex = 0;

        return build(preorder, map, 0, inorder.length-1);
    }

    private TreeNode build(int[] preorder, Map<Integer, Integer> map, int start, int end) {
        if (start > end) return null;

        int preorderVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(preorderVal);
        int inorderIndex = map.get(preorderVal);

        root.left = build(preorder, map, start, inorderIndex-1);
        root.right = build(preorder, map, inorderIndex+1, end);

        return root;
    }
}

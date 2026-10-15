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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                sb.append("null").append(",");

                continue;
            }
            sb.append(curr.val);
            sb.append(",");
            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        System.out.println("DATA: " + data);

        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 1;

        while(!queue.isEmpty() && idx < strs.length) {
            TreeNode curr = queue.poll();

            if (!strs[idx].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(strs[idx]));
                queue.offer(curr.left);
            }
            idx++;

            if (idx < strs.length && !strs[idx].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(strs[idx]));
                queue.offer(curr.right);
            }
            idx++;
        }

        return root;
    }
}

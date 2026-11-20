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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> parent = new Stack<>();
        Stack<TreeNode> child = new Stack<>();
        parent.push(root);
        boolean leftToRight = true;

        while (!parent.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = parent.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = parent.pop();
                level.add(curr.val);

                if (leftToRight) {
                    if (curr.left != null) child.push(curr.left);
                    if (curr.right != null) child.push(curr.right);
                } else {
                    if (curr.right != null) child.push(curr.right);
                    if (curr.left != null) child.push(curr.left);
                }
            }

            res.add(level);
            leftToRight = !leftToRight;
            parent = child;
            child = new Stack<>();
        }

        return res;
    }
}
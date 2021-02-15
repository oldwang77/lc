/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        dfs(root, list);
        return list;
    }

    public void dfs(TreeNode node, List<Integer> path) {
        if (node == null) {
            return;
        }
        dfs(node.left, path);
        path.add(node.val);
        dfs(node.right, path);
    }
}
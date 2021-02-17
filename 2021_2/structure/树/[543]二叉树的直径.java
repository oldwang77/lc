/**
 * 给定一棵二叉树，你需要计算它的直径长度。 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 */
// 求左右两边的最大深度
// 开始错误的认为，从根节点，左边树的深度+右边树的深度，这样是错误的
// 正确的应该是遍历树的每一个结点，求所有深度中的最大值
class Solution {
    int maxx = Integer.MIN_VALUE;

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    public void maxLength(TreeNode node) {
        if (node == null) {
            return;
        }
        int ans = depth(node.left) + depth(node.right);
        maxx = Math.max(maxx, ans);
        maxLength(node.left);
        maxLength(node.right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxLength(root);
        return maxx;
    }
}
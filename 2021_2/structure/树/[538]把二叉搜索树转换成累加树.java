/**
 * 由于二叉搜索树的特点，中序遍历的结果是有序的 我们可以反向中序遍历， 然后用一个sum进行求和 此时sum的求和顺序为右根左，正好满足题目要求
 */
class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 分清楚两个方面，一个是节点最大的路径值，一个是节点最大贡献值， 这两个是不等价的
 */
class Solution {
    Integer maxx = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 只有正数才会对最大值作出贡献
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        // 更新结点的最大路径值
        int ans = root.val + left + right;
        maxx = Math.max(maxx, ans);
        // 返回结点的最大贡献值
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return maxx;
    }
}
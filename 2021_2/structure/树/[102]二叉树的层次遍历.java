import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList();
        LinkedList<TreeNode> que = new LinkedList<>();
        if (root == null) {
            return result;
        }

        que.add(root);
        while (que.size() != 0) {
            int size = que.size();
            List<Integer> ans = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                // 当前的que中元素是同一层的
                TreeNode node = que.removeFirst();
                ans.add(node.val);
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            result.add(ans);
        }
        return result;
    }
}
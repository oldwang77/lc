import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/**
 * 先序遍历+构建链表
 */
class Solution {
    LinkedList<TreeNode> list = new LinkedList<>();

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node);
        dfs(node.left);
        dfs(node.right);
    }

    public void flatten(TreeNode root) {
        dfs(root);
        // 将list里面的TreeNode转换成链表
        TreeNode dump = new TreeNode(0), tmp = dump;
        for (int i = 0; i < list.size(); i++) {
            dump.left = null;
            dump.right = list.get(i);
            dump = dump.right;
        }
    }
}
package 广度优先搜索;

import javafx.util.Pair;
import 树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最小深度111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int deep = pair.getValue();
            if (node.left == null && node.right == null) {
                return deep;
            }
            if (node.left!=null) {
                queue.offer(new Pair<>(node.left, deep+1));
            }
            if (node.right!=null) {
                queue.offer(new Pair<>(node.right, deep+1));
            }

        }
        return 0;
    }
}

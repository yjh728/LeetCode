package temp;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class 二叉树的最大深度104 {

    public int maxDepth(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(new Pair<>(root, 1));
        }
        int deep = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.remove();
            TreeNode node = pair.getKey();
            int currentDeep = pair.getValue();
            if (deep < currentDeep) {
                deep = currentDeep;
            }
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, currentDeep + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, currentDeep + 1));
            }
        }
        return deep;

        /*int deep = 0;
        if (root != null) {
            int leftDeep = maxDepth(root.left);
            int rightDeep = maxDepth(root.right);
            deep = 1 + leftDeep > rightDeep ? leftDeep : rightDeep;
        }
        return deep;*/
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

package 广度优先搜索;

import javafx.util.Pair;
import 树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class 找树左下角的值513 {
    public int findBottomLeftValue(TreeNode root) {
        int deep = 0;
        int value = root.val;
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int curDeep = pair.getValue();
            if (node.left!=null) {
                queue.offer(new Pair<>(node.left, curDeep+1));
            }
            if (node.right!=null) {
                queue.offer(new Pair<>(node.right, curDeep+1));
            }
            if (deep<curDeep) {
                deep = curDeep;
                value = node.val;
            }
        }
        return value;
    }
}

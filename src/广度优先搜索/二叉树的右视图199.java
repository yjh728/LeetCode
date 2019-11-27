package 广度优先搜索;

import javafx.util.Pair;
import 树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的右视图199 {
    public List<Integer> rightSideView(TreeNode root) {
        int deep = 0;
        int value = root.val;
        List<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 1));
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.remove(queue.size() - 1);
            TreeNode node = pair.getKey();
            int curDeep = pair.getValue();
            if (node.left != null) {
                queue.add(new Pair<>(node.left, curDeep + 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, curDeep + 1));
            }
        }
        return list;
    }
}

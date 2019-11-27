package 广度优先搜索;

import javafx.util.Pair;
import 树.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层次遍历二690 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        List<List<Integer>> lists = new ArrayList<>();
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int deep = pair.getValue();
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, deep + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, deep + 1));
            }
            if (lists.size()>=deep) {
                lists.get(lists.size()-deep).add(node.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                lists.add(0, list);
            }
        }
        return lists;
    }
}

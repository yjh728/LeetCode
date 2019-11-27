package 树;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉树的层次遍历102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listsList = new ArrayList<>();
        if (root == null) {
            return listsList;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int ceng = pair.getValue();
            if (listsList.size() < ceng) {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                listsList.add(list);
            } else {
                listsList.get(ceng - 1).add(node.val);
            }
            if (node.left != null) {
                queue.offer(new Pair<>(node.left, ceng + 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, ceng + 1));
            }
        }
        return listsList;
    }
}

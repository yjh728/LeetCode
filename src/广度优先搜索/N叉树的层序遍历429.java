package 广度优先搜索;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N叉树的层序遍历429 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        List<List<Integer>> lists = new ArrayList<>();
        queue.offer(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<Node, Integer> pair = queue.poll();
            Node node = pair.getKey();
            int deep = pair.getValue();
            for (Node node1:node.children) {
                queue.offer(new Pair<>(node1, deep+1));
            }
            if (lists.size() >= deep) {
                lists.get(deep - 1).add(node.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(node.val);
                lists.add(list);
            }
        }
        return lists;
    }
}

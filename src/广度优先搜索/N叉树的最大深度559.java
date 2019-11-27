package 广度优先搜索;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class N叉树的最大深度559 {
    public int maxDepth(Node root) {
        /*if (root == null) {
            return 0;
        }
        int max = 1;
        if (root.children.size() > 0) {
            for (Node node:root.children) {
                max = Math.max(max, maxDepth(node));
            }
        }
        return max;*/

        if (root == null) {
            return 0;
        }
        int deep = 0;
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        while (!queue.isEmpty()) {
            Pair<Node, Integer> pair = queue.poll();
            Node node = pair.getKey();
            int currentDeep = pair.getValue();
            if (currentDeep > deep) {
                deep = currentDeep;
            }
            for (Node node1 : node.children) {
                queue.offer(new Pair<>(node1, currentDeep + 1));
            }
        }
        return deep;
    }
}

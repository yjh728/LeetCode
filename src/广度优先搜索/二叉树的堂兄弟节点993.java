package 广度优先搜索;

import 树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class 二叉树的堂兄弟节点993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Temp> queue = new LinkedList<>();
        queue.offer(new Temp(null, root, 0));
        Temp temp = null;
        while (!queue.isEmpty()) {
            Temp temp1 = queue.poll();
            if (temp1.curent.left != null)
                queue.offer(new Temp(temp1.curent, temp1.curent.left, temp1.deep + 1));
            if (temp1.curent.right != null)
                queue.offer(new Temp(temp1.curent, temp1.curent.right, temp1.deep + 1));
            if (temp1.curent.val == x || temp1.curent.val == y) {
                if (temp == null) {
                    temp = temp1;
                } else {
                    return temp.deep == temp1.deep && temp.parent != temp1.parent;
                }
            }
        }
        return false;
    }

    class Temp {
        TreeNode parent;
        TreeNode curent;
        int deep;

        public Temp(TreeNode parent, TreeNode curent, int deep) {
            this.parent = parent;
            this.curent = curent;
            this.deep = deep;
        }
    }
}

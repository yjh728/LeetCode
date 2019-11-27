package 树;

import java.util.Stack;

public class 二叉搜索树中第K小的元素230 {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        int i = 0;
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                i++;
                if (i == k) {
                    return node.val;
                }
                node = node.right;
            }
        }
        return i;
    }
}

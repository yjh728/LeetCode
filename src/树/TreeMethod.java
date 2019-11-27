package 树;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeMethod {
    private static int[] array;

    public static void main(String[] args) {
        array = new int[]{3, 5, 6, 0, 0, 8, 0, 0, 7, 9, 0, 0, 10, 0, 0};
        TreeNode root = preCreateTree();
        BFS(root);
//        int[] pre = {3, 5, 6, 8, 7, 9, 10};
//        int[] middle = {6, 5, 8, 3, 9, 7, 10};
//        TreeNode root = pre_middle_createTree(pre, 0, pre.length, middle, 0, middle.length);
//        BFS(root);
//        System.out.println(fun1Deep(root));
    }

    public static void BFS1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
    }

    private static void nbehindDFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null;
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == pre) {
                node = stack.pop();
                System.out.print(node.val + " ");
                pre = node;
                node = null;
            } else {
                node = node.right;
            }
        }
    }

    private static void behindDFS(TreeNode root) {
        if (root != null) {
            behindDFS(root.left);
            behindDFS(root.right);
            System.out.print(root.val + " ");
        }
    }

    private static void nmiddleDFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    private static void middleDFS(TreeNode root) {
        if (root != null) {
            middleDFS(root.left);
            System.out.print(root.val + " ");
            middleDFS(root.right);
        }
    }

    private static void npreDFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                System.out.print(node.val + " ");
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    private static void preDFS(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preDFS(root.left);
            preDFS(root.right);
        }
    }

    static int i = 0;

    //先序创建二叉树
    private static TreeNode preCreateTree() {
        TreeNode root;
        int x = array[i++];
        if (x == 0) {
            root = null;
        } else {
            root = new TreeNode(x);
            root.left = preCreateTree();
            root.right = preCreateTree();
        }
        return root;
    }

    //根据先序和中序序列创建二叉树
    private static TreeNode pre_middle_createTree(int[] pre, int preStart, int preEnd, int[] middle, int middleStart, int middleEnd) {
        if (preStart > preEnd || middleStart > middleEnd) {
            return null;
        }
        int i;
        for (i = middleStart; i < middleEnd; i++) {
            if (middle[i] == pre[preStart]) {
                break;
            }
        }
        TreeNode root = new TreeNode(pre[preStart]);
        root.left = pre_middle_createTree(pre, preStart + 1, i, middle, middleStart, i);
        root.right = pre_middle_createTree(pre, i + 1, preEnd, middle, i + 1, middleEnd);
        return root;
    }

    public static void pre_DFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                System.out.println(node.val);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public static void middle_DFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }

    private static void behind_DFS(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode preNode = null;
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == preNode) {
                node = stack.pop();
                preNode = node;
                System.out.println(node.val);
                node = null;
            } else {
                node = node.right;
            }
        }
    }

    private static void BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private static int fun1Deep(TreeNode root) {
        int deep = 0;
        if (root != null) {
            int leftDeep = fun1Deep(root.left);
            int rightDeep = fun1Deep(root.right);
            deep = leftDeep > rightDeep ? leftDeep + 1 : rightDeep + 1;
        }
        return deep;
    }

    private static int fun2Deep(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int deep = 0;
        if (root != null) {
            queue.add(new Pair<>(root, 1));
        }
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.remove();
            TreeNode node = pair.getKey();
            int currentDeep = pair.getValue();
            if (deep < currentDeep) {
                deep = currentDeep;
            }
            if (node.left != null) {
                queue.add(new Pair<>(node.left, currentDeep + 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, currentDeep + 1));
            }
        }
        return deep;
    }
}

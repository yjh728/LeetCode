package 树;

import java.util.*;

public class 从前序与中序遍历序列构造二叉树105 {
    public static void main(String[] args) {
        int[] preorder = {1, 2};
        int[] inorder = {1, 2};
        TreeNode root = buildTree(preorder, inorder);
        TreeMethod.BFS1(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
/*        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }*/
//        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
        return buildTree(preorder, inorder, 0, 0, inorder.length);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int is, int ie) {
        if (preStart > preorder.length - 1 || is >= ie) {
            return null;
        }
        int index = is;
        for (int i = is; i < ie; i++) {
            if (inorder[i] == preorder[preStart]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = buildTree(preorder, inorder, preStart + 1, is, index);
        //index-is+1表示左子树有几个结点
        root.right = buildTree(preorder, inorder, preStart + index - is + 1, index + 1, ie);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int ps, int pe, int is, int ii) {
        if (is + 1 == ii) {
            return new TreeNode(inorder[is]);
        }
        if (is == ii) {
            return null;
        }
        int index = 0;
        for (int i = is; i < ii; i++) {
            if (inorder[i] == preorder[ps]) {
                index = i;
                break;
            }
        }
        int ps1, pe1 = 0, is1, ii1, ps2, pe2, is2, ii2;
        ps1 = ps + 1;
        for (int i = ps; i < pe; i++) {
            if (preorder[i] == inorder[index - 1]) {
                pe1 = i + 1;
                break;
            }
        }
        is1 = is;
        ii1 = index;

        ps2 = pe1;
        pe2 = pe;
        is2 = index + 1;
        ii2 = ii;
        TreeNode root = new TreeNode(preorder[ps]);

        root.left = buildTree(preorder, inorder, ps1, pe1, is1, ii1);
        root.right = buildTree(preorder, inorder, ps2, pe2, is2, ii2);
        return root;
    }
}

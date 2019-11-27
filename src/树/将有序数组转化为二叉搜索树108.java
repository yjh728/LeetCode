package 树;

import java.util.Arrays;

public class 将有序数组转化为二叉搜索树108 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4, 5};
        TreeNode root = sortedArrayToBST(nums);
        TreeMethod.middle_DFS(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    public static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int middle = (right - left) / 2;
        TreeNode root = new TreeNode(nums[left + middle]);
        root.left = sortedArrayToBST(nums, left, left + middle);
        root.right = sortedArrayToBST(nums, left + middle + 1, right);
        return root;
    }
}

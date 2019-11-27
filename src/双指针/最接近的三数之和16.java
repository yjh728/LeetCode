package 双指针;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * [-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33]
 * 0
 *
 * 0
 */
public class 最接近的三数之和16 {
    public static void main(String[] args) {
        int[] nums = {-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33};
        int target = 0;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int add = nums[i] + nums[l] + nums[r];
                    if (Math.abs(add - target) < min) {
                        min = Math.abs(add - target);
                        sum = add;
                    }
                    if (add == target) {
                        return target;
                    }
                    if (add < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return sum;
    }
}

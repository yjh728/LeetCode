package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class 四数之和18 {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer i : list) {
                System.out.print("" + i + ",");
            }
            System.out.println("]");
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j==i+1||nums[j-1]!=nums[j]) {
                    int l = j + 1;
                    int r = nums.length - 1;
                    while (l < r) {
                        int sum = nums[i] + nums[j] + nums[l] + nums[r];
                        if (sum == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[l]);
                            list.add(nums[r]);
                            if (!ret.contains(list)) {
                                ret.add(list);
                            }
                        }
                        if (sum < target) {
                            l++;
                        } else {
                            r--;
                        }
                    }
                }
            }
        }
        return ret;
    }
}

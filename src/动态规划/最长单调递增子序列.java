package 动态规划;

public class 最长单调递增子序列 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 6, 3, 5, 4, 8, 7, 9, 4};
        System.out.println(longestSubString2(nums));
    }

    //nums为原始序列数组
    private static int longestSubString2(int[] nums) {
        //b数组用来存储长度为i的单调递增子序列的最后一个值得最小值
        //b数组单调递增
        int[] b = new int[nums.length];
        //len用来存储单调递增子序列的最大长度，默认为1
        int len = 1;
        //默认长度为1的单调递增子序列的最小值为第一个数
        b[1] = nums[0];
        for (int i : nums) {//遍历nums数组
            if (i > b[len]) {
                //如果当前数比长度为len单调递增子序列的最大值还大，则说明单调递增子序列长度可以更大，
                // 因此最长单调递增子序列长度自增，同时将此值设为长度为len+1的单调递增子序列的最小值
                b[++len] = i;
            } else {
                //若当前数比长度为len的单调递增子序列的最大值小
                //则将b数组中大于等于此值的最小值更新为此值
                change(b, len, i);
            }
        }
        return len;
    }

    //二分查找确定应该更换的位置,并将此位置上的值更换为i
    //b为要更换的数组，len为数组的有效索引
    private static void change(int[] b, int len, int i) {
        int l = 0, r = len;
        while (l <= r) {
            int middle = l + (r - l) / 2;
            if (b[middle] > i) {
                r = middle - 1;
            } else if (b[middle] < i) {
                l = middle + 1;
            } else {
                return;
            }
        }
        b[l] = i;
    }

    private static int longestSubString(int[] nums) {
        int[] longest = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            longest[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            int max = longest[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    int temp = longest[j] + 1;
                    max = max > temp ? max : temp;
                }
            }
            if (max > longest[i]) {
                longest[i] = max;
            }
        }
        return max(longest);
    }

    private static int max(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }
}

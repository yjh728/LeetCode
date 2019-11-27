package 字符串;

public class One {

    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i]+nums[j]==target) {
                    ints[0] = i;
                    ints[2] = j;
                    flag = true;
                    break;
                }
            }
            if(flag) {
                break;
            }
        }
        return ints;
    }
}

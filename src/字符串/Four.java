package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ints = new int[nums1.length + nums2.length];
        int k = 0;
        for (int i = 0; i < nums1.length; i++) {
            ints[k++] = nums1[i];
        }
        for (int j = 0; j < nums2.length; j++) {
            ints[k++] = nums2[j];
        }
        Arrays.sort(ints);
        if (k % 2 == 0) {
            return (ints[k / 2 - 1] + ints[k / 2]) / 2.0;
        } else {
            return ints[k / 2];
        }
    }
}

package 算法期末复习;

import java.util.Arrays;
import java.util.Scanner;

public class P106多机调度 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] renWu = new int[n];
        int[] jiQi = new int[m];
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            renWu[i] = sc.nextInt();
        }
        Arrays.sort(renWu);
        for (int i = 0; i <= n / 2; i++) {
            int temp = renWu[i];
            renWu[i] = renWu[n - i - 1];
            renWu[n - 1 - i] = temp;
        }
        for (int i = 0; i < n; i++) {
            int index = min(jiQi, m);
            x[i] = index;
            jiQi[index] += renWu[i];
        }
        System.out.println(max(jiQi, m));
    }

    private static int max(int[] jiQi, int m) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (max < jiQi[i]) {
                max = jiQi[i];
            }
        }
        return max;
    }

    private static int min(int[] jiQi, int m) {
        int min = 0;
        for (int i = 0; i < m; i++) {
            if (jiQi[min] > jiQi[i]) {
                min = i;
            }
        }
        return min;
    }
}
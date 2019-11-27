package 算法期末复习;

import java.util.Arrays;
import java.util.Scanner;

public class P81最小m段和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[n + 1];
        int[][] max = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {//i个数分成1段的最大和
            max[i][1] = max[i - 1][1] + array[i];
        }
        for (int i = 1; i <= n; i++) {//i个数
            for (int j = 2; j <= m; j++) {//分成j段
                int min = Integer.MAX_VALUE;
                for (int k = 1; k < i; k++) {//前k个为j-1段，后面剩下的为一段
                    int temp = Math.max(max[k][j - 1], max[i][1] - max[k][1]);
                    if (min > temp) {
                        min = temp;
                    }
                }
                max[i][j] = min;
            }
        }
        System.out.println(max[array.length - 1][m]);
    }
}

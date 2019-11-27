package 动态规划;

import java.util.Scanner;

public class 最小m段和 {
    public static void main(String[] args) {
        int n, m;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] a = new int[n + 1];
        int[][] x = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            x[i][1] = x[i - 1][1] + a[i];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                int minValue = Integer.MAX_VALUE;
                for (int k = 1; k < i; k++) {
                    int temp = Math.max(x[i][1] - x[k][1], x[k][j - 1]);
                    if (temp < minValue) {
                        minValue = temp;
                    }
                }
                x[i][j] = minValue;
            }
        }
        System.out.println(x[n][m]);
    }
}

package 算法期末复习;

import java.util.Scanner;

public class P83最大k乘积问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String I = sc.next();
        if (n < k) {
            System.out.println("无解");
        } else {
            int[][] max = new int[n + 1][k + 1];
            for (int i = 1; i <= n; i++) {
                max[i][1] = Integer.valueOf(I.substring(0, i));
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 2; j <= k; j++) {
                    int maxValue = Integer.MIN_VALUE;
                    for (int t = 1; t < i; t++) {
                        int temp = max[t][j - 1] * Integer.valueOf(I.substring(t));
                        if (maxValue < temp) {
                            maxValue = temp;
                        }
                    }
                    max[i][j] = maxValue;
                }
            }
            System.out.println(max[n][k]);
        }
    }
}

package 算法期末复习;

import java.util.Scanner;

public class P80数字三角形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] array = new int[n][n];
        int[][] max = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            max[n - 1][i] = array[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                max[i][j] = Math.max(max[i + 1][j] + array[i][j], max[i + 1][j + 1] + array[i][j]);
            }
        }
        System.out.println(max[0][0]);
    }
}

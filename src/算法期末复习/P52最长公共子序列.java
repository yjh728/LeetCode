package 算法期末复习;

import java.util.Scanner;

public class P52最长公共子序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        c = new int[s1.length() + 1][s2.length() + 1];
        b = new int[s1.length() + 1][s2.length() + 1];
        LCSLength(s1, s2);
        LCS(s1.length(), s2.length(), s1);
    }

    private static int[][] c, b;//c数组用来存储最长公共子序列的长度，b数组用来存储类型

    private static void LCSLength(String s1, String s2) {
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 1;
                } else if (c[i - 1][j] > c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 2;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 3;
                }
            }
        }
    }

    private static void LCS(int i, int j, String s) {
        if (i == 0 || j == 0) {
            return;
        }
        if (b[i][j] == 1) {
            LCS(i - 1, j - 1, s);
            System.out.print(s.charAt(i - 1));
        } else if (b[i][j] == 2) {
            LCS(i - 1, j, s);
        } else {
            LCS(i, j - 1, s);
        }
    }
}

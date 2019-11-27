package 回溯;

import java.util.Scanner;

public class n后问题 {
    private static int[] x;
    private static int sum;

    public static void main(String[] args) {
        int t = 1;
        int n = new Scanner(System.in).nextInt();
        x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = i;
        }
        backTrack1(t, n);
        System.out.println(sum);
    }

    private static void backTrack1(int t, int n) {
        if (t > n) {
            outPut(n);
            sum++;
        } else {
            for (int i = t; i <= n; i++) {
                swap(t, i);
                if (t == 1 || allow(t)) {
                    backTrack1(t + 1, n);
                }
                swap(i, t);
            }
        }
    }

    private static void swap(int t, int i) {
        int temp = x[t];
        x[t] = x[i];
        x[i] = temp;
    }

    private static void outPut(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i] != j) {
                    System.out.print("0");
                } else {
                    System.out.print(x[i]);
                }
            }
            System.out.println();
        }
        System.out.println("--------------");
    }

    private static void backTrack(int t, int n) {
        if (t > n) {
            outPut(n);
            sum++;
        } else {
            for (int i = 1; i <= n; i++) {
                x[t] = i;
                if (allow(t)) {
                    backTrack(t + 1, n);
                }
            }
        }
    }

    private static boolean allow(int t) {
        for (int i = 1; i < t; i++) {
            if (Math.abs(x[t] - x[i]) == Math.abs(t - i)) {//同列或对角线
                return false;
            }
        }
        return true;
    }
}

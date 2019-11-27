package 算法期末复习;

import java.util.Scanner;

public class P120n后问题 {
    private static int n;
    private static int[] x;

    public static void main(String[] args) {
        n = new Scanner(System.in).nextInt();
        x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            x[i] = i;
        }
        backTrack(1);
    }

    private static void backTrack(int t) {
        if (t > n) {
            print();
        } else {
            for (int i = t; i <= n; i++) {
                swap(x, t, i);
                if (could(t)) {
                    backTrack(t + 1);
                }
                swap(x, t, i);
            }
        }
    }

    private static boolean could(int t) {
        for (int i = 1; i < t; i++) {
            if ((t - i) == Math.abs(x[t] - x[i])) {
                return false;
            }
        }
        return true;
    }

    private static void swap(int[] x, int t, int i) {
        int temp = x[t];
        x[t] = x[i];
        x[i] = temp;
    }

    private static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i] == j) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

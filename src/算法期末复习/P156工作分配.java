package 算法期末复习;

import java.util.Scanner;

public class P156工作分配 {

    private static int n;
    private static int[][] array;
    private static int[] x;
    private static int bestW;
    private static int[] bestX;
    private static int w;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        array = new int[n + 1][n + 1];
        x = new int[n + 1];
        bestX = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                array[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i <= n; i++) {
            x[i] = i;
        }
        bestW = Integer.MAX_VALUE;
        backTrack(1);
        System.out.println(bestW);
    }

    private static void backTrack(int t) {
        if (t > n) {
            w = getW();
            if (w < bestW) {
                bestW = w;
                for (int i = 1; i <= n; i++) {
                    bestX[i] = x[i];
                }
            }
        } else {
            for (int i = t; i <= n; i++) {
                swap(x, i, t);
                backTrack(t + 1);
                swap(x, i, t);
            }
        }
    }

    private static int getW() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += array[i][x[i]];
        }
        return sum;
    }

    private static void swap(int[] x, int i, int t) {
        int temp = x[i];
        x[i] = x[t];
        x[t] = temp;
    }
}

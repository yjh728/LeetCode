package 算法期末复习;

import java.util.Scanner;

public class P119装载问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        xiang = new int[n + 1];
        chuan = new int[c + 1];
        for (int i = 1; i <= n; i++) {
            xiang[i] = sc.nextInt();
        }
        for (int i = 1; i <= c; i++) {
            chuan[i] = sc.nextInt();
        }
        x = new int[n + 1];
        bestX = new int[n + 1];
        backTrack(1);
        System.out.println(bestW);
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            builder.append(',').append(bestX[i]);
        }
        System.out.println(builder.toString().substring(1));
    }

    private static int bestW;
    private static int[] bestX;
    private static int w;
    private static int[] x;
    private static int n;
    private static int[] chuan;
    private static int[] xiang;
    private static int c;

    private static void backTrack(int t) {
        if (t > n) {
            if (w > bestW) {
                bestW = w;
                for (int i = 1; i <= n; i++) {
                    bestX[i] = x[i];
                }
            }
        } else {
            for (int i = 1; i <= c; i++) {
                if (chuan[i] >= xiang[t]) {
                    x[t] = 1;
                    chuan[i] -= xiang[t];
                    w += xiang[t];
                    backTrack(t + 1);
                    x[t] = 0;
                    chuan[i] += xiang[t];
                    w -= xiang[t];
                    backTrack(t + 1);
                } else {
                    x[t] = 0;
                    backTrack(t + 1);
                }
            }
        }
    }
}
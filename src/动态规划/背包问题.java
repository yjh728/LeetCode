package 动态规划;

import java.util.Scanner;

public class 背包问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] weight = new int[n+1];
        int[] value = new int[n+1];

        for (int i=1; i<=n; i++) {
            value[i] = sc.nextInt();
            weight[i] = sc.nextInt();
        }

        int[][] m = new int[n + 1][c + 1];
        package01(weight, value, c, n, m);
        System.out.println(m[1][c]);
    }
    //weight中存储所有物品重量，value为对应物品的价值，V为对应物品的体积
    //c为背包最大容量，d为最大容积，m为当前容量和容积的最大价值
    private static void package01(int[] weight, int[] value, int[] V, int c, int d, int n, int[][][] m) {
        //先考虑第n个物品能否装下
        for (int i = 0; i <= c; i++) {//背包容量从0开始考虑，一直到最大值c
            for (int j = 0; j <= d; j++) {//背包容积从0开始考虑，一直到最大值d
                if (i >= weight[n] && j >= V[n]) {//如果背包可以装下当前物品，将最大价值置为物品n的价值
                    m[n][i][j] = value[n];
                } else {//装不下就置为0
                    m[n][i][j] = 0;
                }
            }
        }
        for (int i = n - 1; i >= 1; i--) {//从第n-1个物品开始考虑，直到第一个考虑完
            for (int j = 0; j <= c; j++) {//背包容量从0开始考虑，一直到最大值c
                for (int k = 0; k <= d; k++) {//背包容积从0开始考虑，一直到最大值d
                    if (j >= weight[i] && k >= V[i]) {//如果当前背包容量可以装下第i个物品
                        //背包当前容量和容积装第i个物品和不装哪个价值大
                        m[i][j][k] = Math.max(m[i + 1][j][k], m[i + 1][j - weight[i]][k - V[i]] + value[i]);
                    } else {
                        //第i个物品装不下，则当前背包容量和容积的最大价值为第i+1个物品考虑后的最大价值
                        m[i][j][k] = m[i + 1][j][k];
                    }
                }
            }
        }
    }

    private static void package01(int[] weight, int[] value, int c, int n, int[][] m) {
        for (int i = 0; i <= c; i++) {
            if (i < weight[n]) { // 当背包容量小于最后一个物体体积时，最大价值为0
                m[n][i] = 0;
            } else { // 当背包容量大于最后一个物体体积时，最大价值为最后一个物体体积
                m[n][i] = value[n];
            }
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j <= c; j++) {
                if (weight[i] <= j) {
                    m[i][j] = Math.max(m[i + 1][j], m[i + 1][j - weight[i]] + value[i]);
                } else {
                    m[i][j] = m[i + 1][j];
                }
            }
        }
    }
}

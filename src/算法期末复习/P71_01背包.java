package 算法期末复习;

public class P71_01背包 {
    public static void main(String[] args) {
        int n = 5;
        int c = 10;
        m = new int[n + 1][c + 1];
        int[] w = {0, 2, 2, 6, 5, 4};
        int[] v = {0, 6, 3, 5, 4, 6};
        package01(n, c, w, v);
        System.out.println(m[1][c]);
    }

    private static int[][] m;

    private static void package01(int n, int c, int[] w, int[] v) {
        for (int i = 1; i <= c; i++) {
            if (w[n] <= i) {
                m[n][i] = v[n];
            }
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (w[i] <= j) {
                    m[i][j] = Math.max(m[i + 1][j], m[i + 1][j - w[i]] + v[i]);
                } else {
                    m[i][j] = m[i + 1][j];
                }
            }
        }
    }
}

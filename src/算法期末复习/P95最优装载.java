package 算法期末复习;

import java.util.Arrays;

public class P95最优装载 {
    public static void main(String[] args) {
        int c = 10;
        int[] w = {1, 3, 2, 4, 2, 4, 6, 3};
        int[] x = new int[w.length];
        loading(c, w, x);
    }

    private static void loading(int c, int[] w, int[] x) {
        Arrays.sort(w);
        int i = 0;
        while (c >= w[i]) {
            x[i] = 1;
            c -= w[i];
            i++;
        }
    }
}

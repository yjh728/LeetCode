package 算法期末复习;

import java.util.Scanner;

public class P113最优分解 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        if (n <= 4) {
            System.out.println("无解");
        } else {
            int max = 2;
            int[] x = new int[n];
            int k = 0;
            while (n >= max) {
                x[k++] = max;
                n -= max;
                max++;
            }
            int count = k;
            if (n > count) {
                for (int i = 1; i <= n - count; i++) {
                    x[k - i] += 1;
                }
                n = count;
            }
            while (n > 0) {
                x[--k] += 1;
                n -= 1;
            }
            int c = 1;
            for (int i = 0; i < count; i++) {
                c *= x[i];
            }
            System.out.println(c);
        }
    }
}

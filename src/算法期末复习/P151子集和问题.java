package 算法期末复习;

import java.util.Scanner;

public class P151子集和问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        c = sc.nextInt();
        array = new int[n + 1];
        x = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = sc.nextInt();
        }
        backTrack(1);
    }

    private static int n;
    private static int c;
    private static int[] array;
    private static int sum;
    private static int[] x;

    private static void backTrack(int t) {
        if (t > n) {
            if (sum == c) {
                StringBuilder builder = new StringBuilder();
                for (int i = 1; i <= n; i++) {
                    if (x[i] == 1) {
                        builder.append(',').append(array[i]);
                    }
                }
                System.out.println(builder.toString().substring(1));
            }
        } else {
            if (sum + array[t] <= c) {
                sum += array[t];
                x[t] = 1;
                backTrack(t + 1);
                sum -= array[t];
                x[t] = 0;
                backTrack(t + 1);
            } else {
                backTrack(t + 1);
            }
        }
    }
}

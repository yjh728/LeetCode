package 算法期末复习;

import java.util.Arrays;
import java.util.Scanner;

public class P110多处最优服务次序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] guKe = new int[n];
        for (int i = 0; i < n; i++) {
            guKe[i] = sc.nextInt();
        }
        Arrays.sort(guKe);
        int[] dengDai = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i < s) {
                dengDai[i] = guKe[i];
            } else {
                dengDai[i] = dengDai[i - s] + guKe[i];
            }
            sum += dengDai[i];
        }
        System.out.println(sum / (n + 0.0));
    }
}

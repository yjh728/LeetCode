package 贪心;

import java.util.*;

public class 删数问题 {
    public static void main(String[] args) {
        String a;
        int k;
        Scanner sc = new Scanner(System.in);
        a = sc.nextLine();
        k = sc.nextInt();
        int x = del(a, k);
        System.out.println(x);
    }

    private static int del(String a, int k) {
        if (k >= a.length()) {
            return 0;
        }
        StringBuilder builder = new StringBuilder(a);
        while (k-- != 0) {
            int i;
            for (i = 0; i < builder.length() - 1; i++) {
                if (builder.charAt(i) > builder.charAt(i + 1)) {
                    break;
                }
            }
            builder.deleteCharAt(i);
        }
        return Integer.valueOf(builder.toString());
    }
}

package 字符串;

import java.util.Scanner;

public class Five {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(longestPalindrome(scanner.nextLine()));
    }

    public static String longestPalindrome(String s) {
        String s1 = null;
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j >= i; j--) {
                String s2 = s.substring(i, j);
                if (isHuiWen(s2)) {
                    count = j - i;
                    if (max < count) {
                        max = count;
                        s1 = s2;
                    }
                }
            }
        }
        return s1 == null ? "" : s1;
    }

    public static boolean isHuiWen(String s) {
        String s1 = new StringBuilder(s).reverse().toString();
        return s.equals(s1);
    }
}

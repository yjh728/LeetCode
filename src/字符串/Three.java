package 字符串;

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        int max = 0;
        int k = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            i = s.indexOf(s.charAt(k));
            count = 1;
            builder.replace(0, builder.length(), String.valueOf(s.charAt(i)));
            for (int j = i + 1; j < s.length(); j++) {
                if (builder.indexOf(String.valueOf(s.charAt(j))) >= 0) {
                    k = j;
                    break;
                } else {
                    count++;
                    builder.append(s.charAt(j));
                    if (j == s.length() - 1) {
                        return max > count ? max : count;
                    }
                }
            }
            if (max < count) {
                max = count;
            }
        }
        return max;
    }
}

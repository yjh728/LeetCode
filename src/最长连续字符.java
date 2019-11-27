import java.util.Scanner;

public class 最长连续字符 {
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        if (s.length() <= 0) {
            return;
        }
        char a = s.charAt(0);
        int l = 0;
        char a1 = s.charAt(0);
        int l1 = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                l1++;
            } else {
                if (l < l1) {
                    a = a1;
                    l = l1;
                }
                a1 = s.charAt(i);
                l1 = 1;
            }
        }
        if (l < l1) {
            a = a1;
            l = l1;
        }
        for (int i = 0; i < l; i++) {
            System.out.print(a);
        }
    }
}

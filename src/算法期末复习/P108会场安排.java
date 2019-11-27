package 算法期末复习;

import javafx.scene.transform.Scale;

import java.util.Arrays;
import java.util.Scanner;

public class P108会场安排 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        RenWu[] renWus = new RenWu[n];
        for (int i = 0; i < n; i++) {
            RenWu renWu = new RenWu();
            renWu.start = sc.nextInt();
            renWu.end = sc.nextInt();
            renWus[i] = renWu;
        }
        int[] huiChang = new int[n + 1];
        int[] x = new int[n];
        int count = 1;
        huiChang[count] = renWus[0].end;
        Arrays.sort(renWus);
        for (int i = 1; i < n; i++) {
            boolean flag = true;
            for (int j = 1; j <= count; j++) {
                if (renWus[i].start >= huiChang[j]) {
                    x[i] = j;
                    huiChang[j] = renWus[i].end;
                    flag = false;
                }
            }
            if (flag) {
                huiChang[++count] = renWus[i].end;
                x[i] = count;
            }
        }
        System.out.println(count);
    }

    static class RenWu implements Comparable {
        int start;
        int end;

        @Override
        public int compareTo(Object o) {
            RenWu renWu = (RenWu) o;
            return Integer.compare(end, renWu.end);
        }
    }
}

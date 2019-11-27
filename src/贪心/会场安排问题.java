package 贪心;

import java.util.Arrays;
import java.util.Scanner;

public class 会场安排问题 {
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
        System.out.println(solve2(renWus));
    }

    private static int solve2(RenWu[] renWus) {
        T[] a = new T[renWus.length * 2];//该数组中存储任务的时间及类型
        int k = 0;
        for (int i = 0; i < renWus.length; i++) {//将任务的时间及其类型存入数组中
            T t = new T();
            t.x = renWus[i].start;
            t.type = 0;
            a[k++] = t;
            T t1 = new T();
            t1.x = renWus[i].end;
            t1.type = 1;
            a[k++] = t1;
        }
        Arrays.sort(a);//根据时间进行升序排列
        int max = 0;
        int x = 0;
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                x++;
            } else if (a[i].type == 0 && a[i - 1].type == 1 && a[i - 1].x != a[i].x) {//若为开始时间，则会场数加一
                x++;
            } else {//若为结束时间，则会场数减一
                x--;
            }
            if (max < x) {//更新此过程中的最大会场数
                max = x;
            }
        }
        return max;
    }

    private static int solve1(RenWu[] renWus) {
        int[] a = new int[renWus.length];
        Arrays.sort(renWus);
        a[0] = renWus[0].end;
        int min = 1;
        for (int i = 1; i < renWus.length; i++) {
            boolean flag = true;
            for (int j = 0; j < min; j++) {
                if (renWus[i].start >= a[j]) {
                    a[j] = renWus[i].end;
                    flag = false;
                    break;
                }
            }
            if (flag) {
                a[min] = renWus[i].end;
                min++;
            }
        }
        return min;
    }

    static class T implements Comparable {
        int x;
        int type;

        @Override
        public int compareTo(Object o) {
            if (x > ((T) o).x) {
                return 1;
            } else if (x == ((T) o).x) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    static class RenWu implements Comparable {
        int start;
        int end;

        @Override
        public int compareTo(Object o) {
            if (end > ((RenWu) o).end) {
                return 1;
            } else if (end == ((RenWu) o).end) {
                return 0;
            } else {
                return -1;
            }
        }
    }

}

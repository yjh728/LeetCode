package 贪心;

import java.util.Arrays;
import java.util.Scanner;

public class 服务次序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        T[] a = new T[n];
        for (int i = 0; i < n; i++) {
            T t = new T();
            t.m = sc.nextInt();
            a[i] = t;
        }
        System.out.println(solve(a, s));
    }

    private static double solve(T[] a, int s) {//T中保存客户的服务时间和等待时间，s为窗口个数
        Arrays.sort(a);//首先根据客户服务时间对数组进行排序
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (i < s) {//如果是前s个用户，他们的等待时间只是自己的服务时间
                a[i].d = a[i].m;
            } else {//否则，他的等待时间就是他的前一个用户的等待时间加自己的服务时间
                a[i].d = a[i].m + a[i - s].d;
            }
            sum += a[i].d;//sum计算的是每一个用户的等待时间之和
        }
        return (sum + 0.0) / a.length;//返回客户的平均等待时间
    }

    static class T implements Comparable {
        int m;
        int d;

        @Override
        public int compareTo(Object o) {
            return Integer.compare(m, ((T) o).m);
        }
    }
}

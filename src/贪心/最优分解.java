package 贪心;

import java.util.Scanner;

public class 最优分解 {
    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if (n <= 4) { //如果n<=4，则没有最优分解方案
            return 0;
        }
        int x = 2; //将最小因子设置为2
        int mult = 1; //初始化最终乘积为1
        int[] a = new int[n];//用来保存拆分成的数
        int i = 0;//i指向拆分后的最后一个数的索引
        while (n >= x) {//先将n查分为从2开始的连续自然数之和
            n -= x;
            a[i++] = x;
            x++;
        }
        int index = i;//index为拆分成的数的个数
        while (n > 0) {
            --i;
            if (n >= a[i]) {//n最多为a[i]，此时给小于a[i]的每个因子都分配1，将剩下的值加到最大的因子上
                a[i] += n - i;
                n = i;
            } else {
                a[i]++;
                n--;
            }
        }
        for (int j = 0; j < index; j++) {
            mult *= a[j];
        }
        return mult;
    }
}

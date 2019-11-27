package 回溯;

import java.util.Scanner;

public class 子集和问题 {
    private static int[] x;
    private static int[] a;
    private static int n, sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sum = sc.nextInt();
        a = new int[n];
        x = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        solve(0);
        if (!flag){
            System.out.println("无解");
        }
    }

    private static int sumx;
    private static boolean flag;

    private static void solve(int t) {//t代表第几个数，从0开始
        if (t >= n) {//如果最后一个数都考虑过了
            if (sum == sumx) {//如果子集和为sum，则输出子集，sumx为当前子集和
                flag = true;//flag用来标志是否找到一个子集和的和等于sum
                for (int i = 0; i < n; i++) {
                    if (x[i] == 1) {//x数组中存储是否将该位置上的数加入子集
                        System.out.print(a[i] + " ");
                    }
                }
                System.out.println();
            }
        } else {
            x[t] = 1;//将第t个数放入子集中，并更新当前和
            sumx += a[t];
            if (sumx <= sum) {//若当前和小于等于要求和，则考虑下一个数
                solve(t + 1);
            }
            x[t] = 0;//将第t个数取出集合，并更新当前和
            sumx -= a[t];
            solve(t + 1);//考虑下一个数
        }
    }
}

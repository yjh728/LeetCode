package 回溯;

import java.util.Scanner;

public class 最佳调度 {
    private static int n;//n为任务个数
    private static int k;//k为机器个数
    private static int[] time;//time保存每个任务需要的时间

    private static int bestTime;//bestTime为需要最少时间
    private static int[] x;//x保存每个任务工作的机器

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        time = new int[n + 1];
        x = new int[n + 1];
        bestTime = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            time[i] = sc.nextInt();
        }
        backTrack(1);
        System.out.println(bestTime);
    }

    private static void backTrack(int t) {
        if (t > n) {//若最后一个任务都考虑过了
            int minTime = min();//求出最长工作时间
            if (minTime < bestTime) {//若最长工作时间小于当前最小时间，则更新
                bestTime = minTime;
            }
        } else {
            for (int i = 1; i <= k; i++) {//每个任务都可以在k个机器的任意一个机器上工作
                x[t] = i;
                backTrack(t + 1);
            }
        }
    }

    private static int min() {
        int[] temp = new int[k + 1];//temp保存每个机器上的工作时间之和
        for (int i = 1; i < x.length; i++) {//x中保存的是相应作业的工作机器
            temp[x[i]] += time[i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= k; i++) {//求出工作最长时间
            if (max < temp[i]) {
                max = temp[i];
            }
        }
        return max;
    }
}

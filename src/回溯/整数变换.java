package 回溯;

import java.util.Scanner;

public class 整数变换 {
    private static int n, m;//n为原来的数，m为要变成的数

    private static int[] temp;//记录临时路径
    private static int[] result;//记录最少变换路径

    private static int tempCount;//记录临时变换次数
    private static int resultCount;//记录最小变换次数

    public static void main(String[] args) {
        result = new int[21];
        temp = new int[21];
        tempCount = 0;
        resultCount = 5;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        backTrack(n);
        if (flag) {
            for (int i = 1; i <= resultCount; i++) {
                if (result[i] == 1) {
                    System.out.print('f');
                } else if (result[i] == 2) {
                    System.out.print('g');
                }
            }
        } else {
            System.out.println("无法进行变换");
        }
    }

    private static boolean flag = false;

    private static void backTrack(int t) {//t为要变化的数
        if (t == m) {//如果已经变换成功
            flag = true;//flag表示是否变换成功
            //tempCount为当前变换次数，resultCount为最优变换次数
            if (tempCount <= resultCount) {//且当前变换次数小于最小变换次数，则更新最小变换次数和变换次序
                resultCount = tempCount;
                for (int i = 1; i <= resultCount; i++) {
                    result[resultCount - i + 1] = temp[i];//result中存储最优的变换过程，temp中存储临时变换过程（逆序）
                }
            }
            return;//若已经变换成功，就不需要再进行变换了，直接返回
        }
        tempCount++;//增加变换次数
        if (tempCount <= resultCount && t > 0) {//若还可以继续进行变换，则进行f变换
            backTrack(f(t));//f函数中同时设置变换规则
        }
        if (tempCount <= resultCount && t > 0) {//若还可以继续进行变换，则进行g变换
            backTrack(g(t));//g函数中同时设置变换规则
        }
        tempCount--;//减少变换次数
    }

    private static int g(int t) {
        temp[tempCount] = 2;
        return t / 2;
    }

    private static int f(int t) {
        temp[tempCount] = 1;
        return t * 3;
    }
}

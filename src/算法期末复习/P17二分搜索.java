package 算法期末复习;

import java.util.Scanner;

public class P17二分搜索 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入元素个数：");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("输入排好序的n个元素");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.print("请输入要查询的值：");
        int x = sc.nextInt();
        System.out.println(search(array, x));
    }

    private static int search(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == x) {
                return middle;
            } else if (array[middle] < x) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}

package 算法期末复习;

import java.util.Scanner;

public class P22合并排序 {
    private static int n;
    private static int[] array;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入元素个数：");
        n = sc.nextInt();
        array = new int[n];
        System.out.println("输入数组的n个元素");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("排序后的数组为：");
        start = new int[n + 1];
        sort2(array);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(",").append(array[i]);
        }
        System.out.println(builder.toString().substring(1));
    }

    private static int[] start;

    private static void sort2(int[] array) {
        start[0] = 0;
        int count = fenZu();
        while (count > 2) {
            for (int i = 0; i + 2 < count; i += 2) {
                merge(array, start[i], start[i + 1], start[i + 2]);
            }
            count = fenZu();
        }
    }

    private static int fenZu() {
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                start[count++] = i + 1;
            }
        }
        start[count++] = n;
        return count;
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int i = left;
        int j = middle;
        int k = left;
        int[] tempArray = new int[array.length + 1];
        while (i < middle && j < right) {
            if (array[i] <= array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }
        while (i < middle) {
            tempArray[k++] = array[i++];
        }
        while (j < right) {
            tempArray[k++] = array[j++];
        }
        for (int x = left; x < right; x++) {
            array[x] = tempArray[x];
        }
    }

    private static void sort1(int[] array) {
        int[] tempArray = new int[n];
        int s = 1;
        while (s < n) {
            mergePass(array, tempArray, s, n);
            s *= 2;
            mergePass(tempArray, array, s, n);
            s *= 2;
        }
    }

    private static void mergePass(int[] array, int[] tempArray, int s, int n) {
        int i = 0;
        while (i <= n - 2 * s) {
            merge(array, tempArray, i, i + s - 1, i + 2 * s - 1);
            i += 2 * s;
        }
        if (i + s < n) {
            merge(array, tempArray, i, i + s - 1, n - 1);
        } else {
            for (int j = i; j <= n - 1; j++) {
                tempArray[j] = array[j];
            }
        }
    }

    private static void merge(int[] array, int[] tempArray, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        int k = left;
        while (i <= middle && j <= right) {
            if (array[i] <= array[j]) {
                tempArray[k++] = array[i++];
            } else {
                tempArray[k++] = array[j++];
            }
        }
        while (i <= middle) {
            tempArray[k++] = array[i++];
        }
        while (j <= right) {
            tempArray[k++] = array[j++];
        }
    }
}

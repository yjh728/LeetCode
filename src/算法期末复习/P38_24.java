package 算法期末复习;

import java.util.Scanner;

public class P38_24 {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};
        int x = new Scanner(System.in).nextInt();
        int[] accept = find(array, x);
        System.out.println(accept[0] + "," + accept[1]);
    }

    private static int[] find(int[] array, int x) {
        int[] accept = new int[2];
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            int temp = array[middle];
            if (temp == x) {
                accept[0] = middle;
                accept[1] = middle;
                return accept;
            } else if (temp > x) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        accept[0] = high;
        accept[1] = low;
        return accept;
    }
}

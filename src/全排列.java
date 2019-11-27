import java.util.Arrays;

public class 全排列 {
    public static void main(String[] args) {
        int[] a = new int[4];
        for (int i = 0; i < 4; i++) {
            a[i] = i + 1;
        }
        core(a);
    }

    private static void core(int[] array) {
        int length = array.length;
        fullArray(array, 0, length - 1);
    }

    private static boolean swapAccepted(int[] array, int start, int end) {
        for (int i = start; i < end; i++) {
            if (array[i] == array[end]) {
                return false;
            }
        }
        return true;
    }

    private static void fullArray(int[] array, int cursor, int end) {
        if (cursor == end) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = cursor; i <= end; i++) {
                if (!swapAccepted(array, cursor, i)) {
                    continue;
                }
                swap(array, cursor, i);
                fullArray(array, cursor + 1, end);
                swap(array, cursor, i);
            }
        }
    }

    private static void swap(int[] array, int cursor, int i) {
        int x = array[cursor];
        array[cursor] = array[i];
        array[i] = x;
    }
}

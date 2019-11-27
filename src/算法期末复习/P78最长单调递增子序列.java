package 算法期末复习;

public class P78最长单调递增子序列 {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 2, 4, 5, 1};
        int[] index = new int[array.length];
        index[1] = array[1];
        int k = 1;
        for (int x : array) {
            if (x > index[k]) {
                index[++k] = x;
            } else {
                int left = 1;
                int right = k;
                while (left <= right) {
                    int middle = (left + right) / 2;
                    if (index[middle] == x) {
                        break;
                    } else if (index[middle] > x) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                }
                if (left > right) {
                    index[left] = x;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int x : index) {
            if (x != 0) {
                builder.append(',').append(x);
            }
        }
        System.out.println(builder.toString().substring(1));
    }
}

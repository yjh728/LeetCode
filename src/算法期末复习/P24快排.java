package 算法期末复习;

public class P24快排 {
    private static int partition(int[] unsorted, int low, int high) {
        int pivot = unsorted[low];
        int index = low;
        while (low < high) {
            while (low < high && unsorted[high] > pivot) {
                high--;
            }
            while (low < high && unsorted[low] <= pivot) {
                low++;
            }
            if (low < high) {
                int x = unsorted[low];
                unsorted[low] = unsorted[high];
                unsorted[high] = x;
            }
        }
        unsorted[index] = unsorted[low];
        unsorted[low] = pivot;
        return low;
    }

    private static void quickSort(int[] unsorted, int low, int high) {
        int loc = 0;
        if (low < high) {
            loc = partition(unsorted, low, high);
            quickSort(unsorted, low, loc - 1);
            quickSort(unsorted, loc + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] x = {2, 1, 5, 3, 9};
        quickSort(x, 0, x.length - 1);
        StringBuilder builder = new StringBuilder();
        for (int a : x) {
            builder.append(',').append(a);
        }
        System.out.println(builder.toString().substring(1));
    }
}

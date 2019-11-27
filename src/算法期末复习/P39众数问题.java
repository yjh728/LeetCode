package 算法期末复习;

import java.util.*;

public class P39众数问题 {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 2};
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : array) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> iterator = map.entrySet();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : iterator) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : iterator) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}

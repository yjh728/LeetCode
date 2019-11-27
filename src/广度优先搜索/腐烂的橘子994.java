package 广度优先搜索;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 腐烂的橘子994 {
    int[] row = {0, 1, 0, -1};
    int[] col = {1, 0, -1, 0};

    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int minute = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair<>(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();
            for (int i = 0; i < 4; i++) {
                int xx = x + row[i];
                int yy = y + col[i];
                if (xx >= 0 && xx < r && yy >= 0 && yy < c) {
                    if (grid[xx][yy] == 1) {
                        grid[xx][yy] = 2;
                        minute += 1;
                        queue.offer(new Pair<>(xx, yy));
                    }
                }
            }
        }
        for (int[] a : grid) {
            for (int x : a) {
                if (x == 1) {
                    return -1;
                }
            }
        }
        return minute;
    }
}
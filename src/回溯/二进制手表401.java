package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
 * <p>
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 例如，上面的二进制手表读取 “3:25”。
 * <p>
 * 给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。
 * <p>
 * 案例:
 * <p>
 * 输入: n = 1
 * 返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * <p>
 * <p>
 * 注意事项:
 * <p>
 * 输出的顺序没有要求。
 * 小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
 * 分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。
 */
public class 二进制手表401 {
    private static byte[] x = new byte[10];

    public static void main(String[] args) {
        int num = 2;
        List<String> list = readBinaryWatch(num);
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        if (num == 0) {
            list.add("0:00");
        } else {
            backTrack(num, 1, list);
        }
        return list;
    }

    private static void backTrack(int num, int t, List<String> list) {
        if (t > num) {
            int hour = 0;
            for (int i = 0; i < 4; i++) {
                if (x[i] != 0) {
                    hour += Math.pow(2, 3 - i);
                }
            }
            int minute = 0;
            for (int i = 4; i < 10; i++) {
                if (x[i] != 0) {
                    minute += Math.pow(2, 9 - i);
                }
            }
            if (hour < 12 && minute < 60) {
                String s = hour + ":" + (minute >= 10 ? minute : "0" + minute);
                if (!list.contains(s)) {
                    list.add(s);
                }
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (x[i] == 0) {
                    x[i] = 1;
                    backTrack(num, t + 1, list);
                    x[i] = 0;
                }
            }
        }
    }
}

package 回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * <p>
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 * <p>
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 * <p>
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */
public class 字母大小全排列784 {
    public static void main(String[] args) {

    }

    public static List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        backTrack(S, S, 1, S.length(), list);
        return list;
    }

    private static void backTrack(String s, String s1, int i, int length, List<String> list) {
        if (i > length) {
            if (!list.contains(s)) {
                list.add(s);
            }
        }
    }
}

package 双指针;

/**
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 */
public class 实现strStr28 {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("helol", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() <= 0) {
            return 0;
        }
        for (int i = 0, j = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                i-=j;
                j = 0;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
}

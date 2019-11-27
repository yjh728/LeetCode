import java.util.Collections;

public class 最长公共前缀14 {
    /*
    编写一个函数来查找字符串数组中的最长公共前缀。

    如果不存在公共前缀，返回空字符串 ""。

    示例 1:

    输入: ["flower","flow","flight"]
    输出: "fl"
    示例 2:

    输入: ["dog","racecar","car"]
    输出: ""
    解释: 输入不存在公共前缀。
    说明:

    所有输入只包含小写字母 a-z 。
     */
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix(new String[]{"a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length<=0) {
            return "";
        }
        if (strs.length==1) {
            return strs[0];
        }
        int min = Integer.MAX_VALUE;
        int k = -1;
        for (int i = 0; i < strs.length; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
                k = i;
            }
        }
        for (int j = min - 1; j > 0; j--) {
            String s = strs[k].substring(0, j);
            int count = 0;
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].indexOf(s)==0) {
                    count++;
                }
            }
            if(count==strs.length) {
                return s;
            }
        }
        return "";
    }
}

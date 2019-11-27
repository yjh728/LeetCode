package 动态规划;

public class 编辑距离 {
    public static void main(String[] args) {
        String s1 = " fasdf";
        String s2 = " asd";
        int[][] m = new int[s1.length()][s2.length()];
        changeCount(s1, s2, m);
        System.out.println(m[s1.length() - 1][s2.length() - 1]);
    }

    //s1位原字符串，s2位目标字符串，m中存储最少更改次数
    private static void changeCount(String s1, String s2, int[][] m) {
        for (int i = 0; i < s1.length(); i++) {
            m[i][0] = i;//目标字符串长度为0时，最小更改次数为原字符串长度
        }
        for (int i = 0; i < s2.length(); i++) {
            m[0][i] = i;//当原字符串长度为0时，最小更改次数为目标字符串长度
        }
        for (int i = 1; i < s1.length(); i++) {
            for (int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    //若两个字符串最后一个字符相同则最少更改次数为
                    //原字符串和目标字符串都不考虑最后一个字符的时候的最小更改次数
                    m[i][j] = m[i - 1][j - 1];
                } else {//两字符串最后一个字符不同
                    //删除最后一个字符：此时最小更改次数=原字符串不考虑最后一个字符的最小更改次数+1
                    int del = 1 + m[i - 1][j];
                    //添加一个字符：此时最小更改次数=目标字符串不考虑最后一个字符的最小更改次数+1
                    int add = 1 + m[i][j - 1];
                    //改最后一个字符：
                    //此时最小更改次数=原字符串和目标字符串都不考虑最后一个字符的时候的最小更改次数+1
                    int change = 1 + m[i - 1][j - 1];
                    //求删、加、改三种情况的最小更改次数
                    m[i][j] = min(del, add, change);
                }
            }
        }
    }

    private static int min(int del, int add, int change) {
        int min = del > add ? add : del;
        min = min > change ? change : min;
        return min;
    }
}

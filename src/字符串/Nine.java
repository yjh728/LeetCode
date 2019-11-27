package 字符串;

public class Nine {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(10));
    }

    /*
     *  判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     */
    private static boolean isPalindrome(int x) {
        StringBuilder builder = new StringBuilder().append(x).reverse();
        return String.valueOf(x).equals(builder.toString());
    }
}

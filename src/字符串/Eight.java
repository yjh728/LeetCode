package 字符串;

public class Eight {
    public static void main(String[] args) {
        System.out.println(Double.valueOf("+123"));
        System.out.println(myAtoi("+"));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String str) {
        String s = str.trim();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (i == 0 && (a == 45 || a == 43)) {
                builder.append(a);
            } else if (i != 0 && (a == 45 || a == 43)) {
                break;
            } else if (isShu(a)) {
                builder.append(a);
            } else {
                break;
            }
        }
        double result;
        if (builder.length() == 0 || builder.toString().equals("-") || builder.toString().equals("+")) {
            result = 0;
        } else {
            result = Double.valueOf(builder.toString());
        }
        if (result > (Math.pow(2, 31) - 1)) {
            result = Math.pow(2, 31) - 1;
        } else if (result < Math.pow(-2, 31)) {
            result = Math.pow(-2, 31);
        }
        return (int) result;
    }

    public static boolean isShu(char a) {
        if ((a >= 48 && a <= 57)) {
            return true;
        }
        return false;
    }
}

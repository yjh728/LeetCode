package 字符串;

public class Seven {
    public static void main(String[] args) {
        System.out.println(reverse(-2147483648));
    }
    /*
     *  给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *  假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]
     *  请根据这个假设，如果反转后整数溢出那么就返回 0。
     */
    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        double result;
        if (x > 0) {
            StringBuilder builder = new StringBuilder().append(x).reverse();
            String s = builder.toString();
            result = Double.valueOf(s);

        } else {
            String  builder = new StringBuilder().append(x).reverse().toString();
            String s = builder.toString().substring(0, builder.length()-1);
            result = Double.valueOf(s)*-1;
        }
        if(result > (Math.pow(2, 31)-1) || result < Math.pow(-2, 31)) {
            return 0;
        }
        return (int) result;
    }
}

import java.util.HashMap;
import java.util.Scanner;

public class 两串字符及字符个数是否相等 {
    public static void main(String[] args) {
//        HashMap<Character, Integer> map1 = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int[] array1 = new int[128];
        int[] array2 = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            array1[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            array2[s2.charAt(i)]++;
        }
        boolean flag = true;
        for (int i = 0; i < 128; i++) {
            if (array1[i] != array2[i]) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
        /*for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            if (map1.containsKey(a)) {
                map1.put(a, map1.get(a) + 1);
            } else {
                map1.put(a, 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            char a = s2.charAt(i);
            if (map2.containsKey(a)) {
                map2.put(a, map2.get(a) + 1);
            } else {
                map2.put(a, 1);
            }
        }
        System.out.println(map1.equals(map2));*/
    }
}

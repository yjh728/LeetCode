package 链表;

import java.util.*;

public class 链表组件817 {
    public int numComponents(ListNode head, int[] G) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : G) {
            set.add(x);
        }
        int count = 0;
        HashSet<Integer> temp = new HashSet<>();
        while (head != null) {
            if (set.contains(head.val)) {
                temp.add(head.val);
            } else {
                if (temp.size() > 0) {
                    count++;
                    temp.clear();
                }
            }
            head = head.next;
        }
        if (temp.size() > 0) {
            count++;
        }
        return count;
    }
}

package 链表;

import java.util.ArrayList;

public class 反转链表206 {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode node = current.next;
            current.next = pre;
            pre = current;
            current = node;
        }
        return pre;
    }

}

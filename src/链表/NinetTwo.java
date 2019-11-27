package 链表;

public class NinetTwo {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = head, next;
        int x = m;
        while (x-- != 0) {
            pre = pre.next;
        }
        int k = n - m;
        ListNode node = pre;
        pre = null;
        while (k-- != 0) {
            next = node.next;
            node.next = pre;
            pre = next;
            node = pre;
        }
        if (m == 1) {
            return pre;
        } else {
            return head;
        }
    }
}

package 链表;

public class TwoZeroSix {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head, next;
        head = null;
        while (pre != null) {
            next = pre.next;
            pre.next = head;
            head = pre;
            pre = next;
        }
        return head;
    }
}

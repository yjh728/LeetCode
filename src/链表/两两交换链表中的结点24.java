package 链表;

public class 两两交换链表中的结点24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        ListNode pre = head;
        head = head.next;
        while (head != null) {
            pre.next = head.next;
            head.next = pre;
            head = pre.next.next;
            pre = pre.next;
        }
        return node;
    }
}

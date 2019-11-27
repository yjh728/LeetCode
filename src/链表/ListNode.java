package 链表;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode create(int[] array) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int x : array) {
            p.next = new ListNode(x);
            p = p.next;
        }
        return head.next;
    }
}

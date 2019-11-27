package 链表;

public class 移除链表元素203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode list = new ListNode(-1);
        list.next = head;
        ListNode pre = list;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
                head.next = null;
                head = pre.next;
            } else {
                pre = head;
                head = head.next;
            }
        }
        return list.next;
    }
}

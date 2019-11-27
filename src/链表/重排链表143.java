package 链表;

public class 重排链表143 {
    public void reorderList(ListNode head) {
        if (head != null && head.next != null && head.next.next != null) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode list = slow.next;
            slow.next = null;
            ListNode pre = null;
            while (list != null) {
                ListNode temp = list.next;
                list.next = pre;
                pre = list;
                list = temp;
            }
            while (pre != null) {
                ListNode next = pre.next;
                pre.next = head.next;
                head.next = pre;
                head = pre.next;
                pre = next;
            }
        }
    }
}

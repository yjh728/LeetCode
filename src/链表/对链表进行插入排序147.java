package 链表;

public class 对链表进行插入排序147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        ListNode list = new ListNode(-1);
        list.next = head;
        head.next = null;
        while (node != null) {
            ListNode temp = node.next;
            ListNode p = list;
            ListNode c = list.next;
            while (c != null && c.val < node.val) {
                p = c;
                c = c.next;
            }
            node.next = c;
            p.next = node;
            node = temp;
        }
        return list.next;
    }
}

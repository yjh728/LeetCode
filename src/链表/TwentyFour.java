package 链表;

public class TwentyFour {
    public ListNode swapPairs(ListNode head) {
        if(head==null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode list = new ListNode(0);
        list.next = head;
        ListNode node = head;
        ListNode pre = list;
        while (node != null && node.next != null) {
            pre.next = node.next;
            pre = node;
            ListNode node1 = node.next;
            node.next = node1.next;
            node1.next = node;
            node = pre.next;
        }
        return list.next;
    }

}

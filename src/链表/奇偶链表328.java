package 链表;

public class 奇偶链表328 {
    public ListNode oddEvenList(ListNode head) {
        /*if (head != null && head.next != null && head.next.next != null) {
            ListNode node = head.next.next;
            ListNode pre = head;
            ListNode np = head.next;
            while (node != null) {
                ListNode temp = node.next;
                np.next = node.next;
                node.next = pre.next;
                pre.next = node;
                pre = node;
                if (temp == null) {
                    node = null;
                } else {
                    np = temp;
                    node = temp.next;
                }

            }
        }
        return head;*/
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

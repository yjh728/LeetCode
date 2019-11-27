package 链表;

public class 两数相加445 {

    int length1 = 0, length2 = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1, 1);
        l2 = reverseList(l2, 2);
        ListNode c = length1 > length2 ? l1 : l2;
        ListNode r = c;
        ListNode d = c == l1 ? l2 : l1;
        while (d != null) {
            int add = d.val + c.val;
            c.val = add % 10;
            if (add >= 10) {
                if (c.next == null) {
                    c.next = new ListNode(add / 10);
                } else {
                    c.next.val += add / 10;
                }
            }
            d = d.next;
            c = c.next;
        }
        while (c != null && c.val >= 10) {
            if (c.next == null) {
                c.next = new ListNode(c.val / 10);
            } else {
                c.next.val += c.val / 10;
            }
            c.val = c.val % 10;
            c = c.next;
        }
        return reverseList(r, 1);
    }

    private ListNode reverseList(ListNode list, int i) {
        ListNode pre = null;
        while (list != null) {
            if (i == 1) {
                length1++;
            } else {
                length2++;
            }
            ListNode next = list.next;
            list.next = pre;
            pre = list;
            list = next;
        }
        return pre;
    }
}

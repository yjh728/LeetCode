package 字符串;

public class Two {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode list = new ListNode(0);
        ListNode n3 = list;
        ListNode p = n3;
        while (n1 != null && n2 != null) {
            n3.next = new ListNode(0);
            int x = n1.val + n2.val + n3.val;
            if (x >= 10) {
                n3.val = x % 10;
                n3.next.val += x / 10;
            } else {
                n3.val = x;
            }
            p = n3;
            n1 = n1.next;
            n2 = n2.next;
            n3 = n3.next;
        }
        while (n1 != null) {
            n3.next = new ListNode(0);
            int x = n1.val + n3.val;
            if (x >= 10) {
                n3.val = x % 10;
                n3.next.val += x / 10;
            } else {
                n3.val = x;
            }
            p = n3;
            n1 = n1.next;
            n3 = n3.next;
        }

        while (n2 != null) {
            n3.next = new ListNode(0);
            int x = n2.val + n3.val;
            if (x >= 10) {
                n3.val = x % 10;
                n3.next.val += x / 10;
            } else {
                n3.val = x;
            }
            p = n3;
            n2 = n2.next;
            n3 = n3.next;
        }
        if (n3.val == 0) {
            p.next = null;
        }
        return list;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

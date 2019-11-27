package 链表;

public class Nineteen {

    public static void main(String[] args) {
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = head;
            int count = 0;
            while (node != null) {
                node = node.next;
                count++;
            }
            int x = count - n;
            if (x == 0) {
                return head.next;
            } else {
                node = head;
                while (x-- != 0) {
                    node = node.next;
                }
                node.next = node.next.next;
            }
            return head;
        }
    }
}

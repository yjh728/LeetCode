package 链表;

public class 排序链表148 {

    public static void main(String[] args) {
        int[] array = {4, 2, 1, 3};
        ListNode head = 有序链表转换二叉搜索树109.create(array);
        head = sortList(head);
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        head = sortList(head);
        slow = sortList(slow);
        return mergeList(head, slow);
    }

    private static ListNode mergeList(ListNode head, ListNode slow) {
        ListNode list = new ListNode(-1);
        ListNode node = list;
        while (head != null && slow != null) {
            if (head.val < slow.val) {
                node.next = head;
                head = head.next;
            } else {
                node.next = slow;
                slow = slow.next;
            }
            node = node.next;
        }
        node.next = head == null ? slow : head;
        return list.next;
    }

}

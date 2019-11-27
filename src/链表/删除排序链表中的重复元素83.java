package 链表;

public class 删除排序链表中的重复元素83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                ListNode temp = node.next;
                node.next = temp.next;
                temp.next = null;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}

package 链表;

public class 回文链表234 {
    /**
     * 判断一个链表是否是回文链表
     * 先用快慢指针找到链表的中间结点，然后逆置链表后半部分
     * 当fast指针指向null时，代表有偶数个结点，否则有奇数个结点。
     * 比较逆置后的后半部分结点和链表前半部分结点即可
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode list = slow;
        ListNode pre = null;
        while (list != null) {
            ListNode node = list.next;
            list.next = pre;
            pre = list;
            list = node;
        }
        if (fast != null) {
            while (pre.next != null) {
                if (pre.val != head.val) {
                    return false;
                }
                pre = pre.next;
                head = head.next;
            }
            return true;
        } else {
            while (pre != null) {
                if (pre.val != head.val) {
                    return false;
                }
                pre = pre.next;
                head = head.next;
            }
            return true;
        }
    }
}

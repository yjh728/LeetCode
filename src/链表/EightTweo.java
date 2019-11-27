package 链表;


public class EightTweo {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode list = new ListNode(0);
        list.next = head;
        ListNode node = list.next;
        int x = node.val;
        node = list.next;
        ListNode pre = list;
        boolean flag = false;
        while (node != null) {
            if (node.next != null && x == node.next.val) {
                pre.next = node.next;
                node = pre.next;
                flag = true;
            } else if (x == node.val && flag) {
                pre.next = node.next;
                node = pre.next;
                flag = false;
                if(node!=null)
                    x = node.val;
            } else {
                pre = node;
                node = node.next;
                if(node!=null)
                    x = node.val;
            }
        }
        return list.next;
    }
}

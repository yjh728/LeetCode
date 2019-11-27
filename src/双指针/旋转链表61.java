package 双指针;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class 旋转链表61 {
    public static void main(String[] args) {
        int[] list = {0, 1, 2};
        ListNode head = createList(list);
        head = rotateRight(head, 4);
        printList(head);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    private static ListNode createList(int[] list) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 0; i < list.length; i++) {
            node.next = new ListNode(list[i]);
            node = node.next;
        }
        node.next = null;
        return head.next;
    }


    public static ListNode rotateRight(ListNode head, int k) {
        ListNode node = head;
        ListNode last = node;
        int count = 0;
        while (node != null) {
            last = node;
            node = node.next;
            count++;
        }
        if (count == 0) {
            return null;
        }
        if (k % count == 0) {
            return head;
        }
        ListNode list = head;
        ListNode p = list;
        for (int i = 0; i < count - k % count; i++) {
            p = list;
            list = list.next;
        }
        p.next = null;
        last.next = head;
        return list;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

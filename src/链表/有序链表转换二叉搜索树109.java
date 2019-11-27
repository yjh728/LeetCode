package 链表;

import 树.TreeMethod;
import 树.TreeNode;

public class 有序链表转换二叉搜索树109 {

    public static void main(String[] args) {
        int[] array = {-10, -3, 0, 5, 9};
        ListNode head = create(array);
        TreeNode root = sortedListToBST(head);
//        TreeMethod.middle_DFS(root);
    }

    public static ListNode create(int[] array) {
        ListNode head = new ListNode(-1);
        ListNode p = head;
        for (int x : array) {
            p.next = new ListNode(x);
            p = p.next;
        }
        return head.next;
    }

    private static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre != null) {
            pre.next = null;
        }
        //此时slow指向中间结点。
        TreeNode root = new TreeNode(slow.val);
        root.setLeft(sortedListToBST(head));
        root.setRight(sortedListToBST(slow.next));
        return root;
    }
/*
    private static ListNode findMiddleElement(ListNode head) {

        // The pointer used to disconnect the left half from the mid node.
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // Iterate until fastPr doesn't reach the end of the linked list.
        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // Handling the case when slowPtr was equal to head.
        if (prevPtr != null) {
            prevPtr.next = null;
        }

        return slowPtr;
    }

    public static TreeNode sortedListToBST(ListNode head) {

        // If the head doesn't exist, then the linked list is empty
        if (head == null) {
            return null;
        }

        // Find the middle element for the list.
        ListNode mid = findMiddleElement(head);

        // The mid becomes the root of the BST.
        TreeNode node = new TreeNode(mid.val);

        // Base case when there is just one element in the linked list
        if (head == mid) {
            return node;
        }

        // Recursively form balanced BSTs using the left and right halves of the original list.
        node.setLeft(sortedListToBST(head));
        node.setRight(sortedListToBST(mid.next));
        return node;
    }*/
}

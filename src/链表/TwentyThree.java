package 链表;

public class TwentyThree {

    public ListNode mergeKLists(ListNode[] lists) {
        int min = Integer.MIN_VALUE;
        int index = -1;
        ListNode list;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && min < lists[i].val) {
                min = lists[i].val;
                index = i;
            }
        }
        list = new ListNode(min);
        lists[index] = lists[index].next;
        list.next = add(lists);
        return list;
    }

    public ListNode add(ListNode[] lists) {
        ListNode node;
        int min = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && min < lists[i].val) {
                min = lists[i].val;
                index = i;
            }
        }
        node = new ListNode(min);
        lists[index] = lists[index].next;
        return node;
    }

}

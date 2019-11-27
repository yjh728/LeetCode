package 链表;

public class 分隔链表725 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ListNode root = ListNode.create(array);
        ListNode[] listNodes = splitListToParts(root, 3);
        System.out.println(listNodes);
    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        if (root == null) {
            return new ListNode[k];
        }
        int count = 0;
        ListNode temp = root;
        //统计结点个数
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        int[] a = new int[k];
        //计算每一段的结点个数，并存入a数组中
        int x = count / k;
        count -= x * k;
        for (int i = 0; i < k; i++) {
            a[i] = x;
        }
        int i = 0;
        while (count-- > 0) {
            a[i++]++;
        }

        ListNode[] r = new ListNode[k];
        int j;
        i = 0;
        ListNode c = root, n = c.next;
        while (i < k) {
            r[i] = c;
            j = 1;
            while (j++ < a[i]) {
                c = n;
                n = c.next;
            }
            if (c != null) {
                c.next = null;
            }
            c = n;
            if (n != null) {
                n = c.next;
            }
            i++;
        }
        return r;
    }
}

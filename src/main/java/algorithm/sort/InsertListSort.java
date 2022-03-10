package algorithm.sort;

public class InsertListSort {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        ListNode result = sort(listNode1);

    }

    /**
     * 几个关键的注意点：
     * // 左边的已经排序好的list如何标识
     * 1. dummyNode是为了 head节点前插入数据的情况
     * 2. lastSortedNode作为最后一个已经排序好的节点的标识
     * @param head
     * @return
     */
    public static ListNode sort(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode sortedNode = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (sortedNode.val <= cur.val) {
                sortedNode = sortedNode.next;
            } else {
                ListNode pre = dummyNode;
                // 这里已经有了对排序好的节点的 终止情况的判断
                while (pre.next.val <= cur.val) {
                    pre = pre.next;
                }

                sortedNode.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = sortedNode.next;
        }
        return dummyNode.next;

    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

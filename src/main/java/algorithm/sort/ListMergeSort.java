package algorithm.sort;

public class ListMergeSort {


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

    public static ListNode sort(ListNode list) {
        if (list == null || list.next == null) {
            return list;
        }
        ListNode right = splitList(list);
        ListNode sortedLeft = sort(list);
        ListNode sortedRight = sort(right);
        return merge(sortedLeft, sortedRight);
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode virtualHeader = new ListNode(-1);
        ListNode index = virtualHeader;
        while (left != null && right != null) {
            if (left.value < right.value) {
                index.next = left;
                left = left.next;
            } else {
                index.next = right;
                right = right.next;

            }
            index = index.next;
        }

        if (left != null) {
            index.next = left;
        }

        if (right != null) {
            index.next = right;
        }

        return virtualHeader.next;

    }

    private static ListNode splitList(ListNode list) {
        ListNode virtualNode = new ListNode(-1);
        ListNode slow = virtualNode;
        ListNode fast = virtualNode;

        virtualNode.next = list;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode result = slow.next;
        slow.next = null;
        return result;
    }


    private static class ListNode {

        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
}

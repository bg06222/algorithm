package algorithm.sort.practice;

/**
 * 整体的思路：
 * 先不停的切分，切分到最后，进行排序，排序好后，进行合并排序
 * 1.先将大链表切分为两个小链表
 * 2.然后分别对两个小链表进行排序
 * 3.将两个排序好的小链表合并起来进行两个链表的排序
 *
 * // 注意切分的方法
 * // 注意排序的方法
 */
public class ListMergeSortPractice1 {

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

    public static ListNode sort(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode right = splitList(head);
        ListNode sortedLeft = sort(head);
        ListNode sortedRight = sort(right);
        return merge(sortedLeft, sortedRight);
    }

    private static ListNode splitList(ListNode head) {
        // 这里使用了虚拟节点，而不是将slow,fast的指针指向第一个head节点，
        // 因为如果默认第一个指针指向head节点，默认就已经向前走了一步了。

        ListNode virtualNode = new ListNode(-1);
        virtualNode.next = head;
        ListNode slow = virtualNode;
        ListNode fast = virtualNode;
        while (fast != null && fast.next != null) {
           fast = fast.next.next;
           slow = slow.next;
        }
        ListNode result = slow.next;
        // 注意这里将slow.next设置为0,将一个链表，切分为了两段
        slow.next = null;
        return result;
    }

    public static ListNode merge(ListNode left, ListNode right) {
        ListNode result = new ListNode(-1);
        ListNode index = result;
        // 这里是做了两个链表的比较
        while (left != null && right != null) {
            if (left.val < right.val) {
                index.next = left;
                left = left.next;
            } else {
                index.next = right;
                right = right.next;
            }
            index = index.next;
        }
        // 注意较长的链表，剩余的部分加入到最终的排序链表中
        if (left != null) {
            index.next = left;
        }
        if (right != null) {
            index.next = right;
        }
        return result.next;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

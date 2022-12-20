package codingInterview;

import java.util.PriorityQueue;

public class LC23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> heap = new PriorityQueue<>(
                (n1, n2) -> n1.val - n2.val
        );
        for (ListNode node : lists) {
            if (node != null) {
                heap.add(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode current = head;
        while (!heap.isEmpty()) {
            ListNode next = heap.poll();
            current.next = next;
            if (next.next != null) {
                heap.add(next.next);
            }
            current = next.next;
        }
        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}

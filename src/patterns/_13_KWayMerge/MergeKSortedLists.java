package patterns._13_KWayMerge;

import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)-> a.val - b.val);
        for (ListNode node : lists) {
            while (node != null) {
                pq.add(new ListNode(node.val));
                node = node.next;
            }
        }

        ListNode head = null;
        ListNode curr = null;
        if (!pq.isEmpty()) {
            curr = pq.poll();
            head = curr;
        }

        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

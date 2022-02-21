package patterns._6_InplaceReversalLinkedList;

/**
 * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized
 * sub-list starting from the head.
 * If, in the end, you are left with a sub-list with less than ‘k’ elements,
 * reverse it too.
 */
public class ReverseEveryKElements {
    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        ListNode curr = head;
        ListNode prev = null;
        while (true) {
            ListNode lastPrev = prev;
            ListNode lastSublist = curr;
            ListNode next = null;

            for (int i = 0; curr != null && i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if (lastPrev != null) {
                lastPrev.next = prev;
            } else {
                head = prev;
            }

            lastSublist.next = curr;

            if (curr == null) {
                break;
            }
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

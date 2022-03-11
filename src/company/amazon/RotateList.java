package company.amazon;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */
public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            len++;
        }
        curr.next = head;

        k = k % len;
        k = len - k;
        curr = head;
        for (int i = 0; i < k - 1; i++) {
            curr = curr.next;
        }
        head = curr.next;
        curr.next = null;

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

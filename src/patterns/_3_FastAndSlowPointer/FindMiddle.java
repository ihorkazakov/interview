package patterns._3_FastAndSlowPointer;

/**
 * Given the head of a Singly LinkedList, write a method to return the
 * middle node of the LinkedList
 * <p>
 * Input: 1 -> 2 -> 3 -> 4 -> 5 -> null
 * Output: 3
 */
public class FindMiddle {
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

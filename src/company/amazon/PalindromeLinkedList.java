package company.amazon;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * Input: head = [1,2,2,1]
 * Output: true
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        while (slow != null) {
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        while (head != null && prev != null) {
            if (head.val != prev.val) {
                return false;
            }

            head = head.next;
            prev = prev.next;
        }

        return true;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

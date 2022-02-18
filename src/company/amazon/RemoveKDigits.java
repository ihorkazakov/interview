package company.amazon;

import java.util.Stack;

/**
 * Given string num representing a non-negative integer num, and an integer k,
 * return the smallest possible integer after removing k  digits from num.
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 */
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        int start = 0;
        if (k >= num.length()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        // int position = 0;
        while (start < len) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > num.charAt(start)) {
                stack.pop();
                k--;
            }
            stack.add(num.charAt(start));
            start++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}

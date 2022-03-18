package company.amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the
 * smallest in lexicographical order among all possible results.
 * <p>
 * Input: s = "bcabc"
 * Output: "abc"
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        char arr[] = s.toCharArray();
        Map<Character, Integer> frequency = new HashMap<>();
        Map<Character, Boolean> exist = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        for (char c : arr) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            if (!exist.containsKey(c)) {
                exist.put(c, false);
            }
        }
        for (char c : arr) {
            frequency.put(c, frequency.get(c) - 1);
            if (exist.get(c) == true) {
                continue;
            } else {
                exist.put(c, true);
                if (!stack.isEmpty() && stack.peek() > c) {
                    while (stack.size() > 0 && stack.peek() > c && frequency.get(stack.peek()) >= 1) {
                        char prev = stack.pop();
                        exist.put(prev, false);
                    }
                }
                stack.push(c);
            }
        }
        String ans = "";
        while (!stack.isEmpty()) {
            ans = stack.pop() + ans;
        }

        return ans;
    }
}

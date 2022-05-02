package company.MustDo75;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t
 * (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 * A substring is a contiguous sequence of characters within the string.
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int totalFnd = t.length();
        String res = "";
        int len = Integer.MAX_VALUE;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int numChar = map.get(c) - 1;
                map.put(c, numChar);

                if (numChar >= 0)
                    totalFnd--;
            }

            while (totalFnd == 0) {
                if (i - j + 1 < len) {
                    res = s.substring(j, i + 1);
                    len = i - j + 1;
                }

                char jChar = s.charAt(j);
                if (map.containsKey(jChar)) {
                    int numJChar = map.get(jChar) + 1;
                    map.put(jChar, numJChar);

                    if (numJChar > 0)
                        totalFnd++;
                }
                j++;
            }
        }

        return res;
    }
}

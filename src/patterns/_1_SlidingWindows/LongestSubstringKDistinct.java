package patterns._1_SlidingWindows;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring in it with no more
 * than K distinct characters.
 *
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa"
 */
public class LongestSubstringKDistinct {
    public int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k) {
            throw new IllegalArgumentException();
        }

        int start = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char right = str.charAt(end);
            map.put(right, map.getOrDefault(right, 0) + 1);
            while (map.size() > k) {
                char left = str.charAt(start);
                map.put(left, map.getOrDefault(left, 0) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }

                start++;
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}

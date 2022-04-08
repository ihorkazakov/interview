package company.MustDo75;

/**
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa"
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int res = 0;
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                res += isPalindrom(s, start, end) ? 1 : 0;
            }
        }

        return res;
    }

    private boolean isPalindrom(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}

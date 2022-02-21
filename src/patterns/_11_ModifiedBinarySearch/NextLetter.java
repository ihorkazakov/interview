package patterns._11_ModifiedBinarySearch;

/**
 * Given a characters array letters that is sorted in non-decreasing order and a character target,
 * return the smallest character in the array that is larger than target.
 *
 * Input: letters = ["c","f","j"], target = "a"
 * Output: "c"
 */
public class NextLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return letters[start % letters.length];
    }
}

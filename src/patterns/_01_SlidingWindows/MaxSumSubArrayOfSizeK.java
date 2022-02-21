package patterns._01_SlidingWindows;

/**
 * Given an array of positive numbers and a positive number ‘k,’ find the
 * maximum sum of any contiguous subarray of size ‘k’.
 *
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */
public class MaxSumSubArrayOfSizeK {
    public int findMaxSumSubArray(int k, int[] arr) {
        int result = 0;
        int winSum = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            winSum += arr[end];

            if (end >= k - 1) {
                result = Math.max(result, winSum);
                winSum -= arr[start];
                start++;
            }
        }

        return result;
    }
}

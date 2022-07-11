package company.MustDo75;

import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class LongestIncreasingSubsequence {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int[] maxLength = new int[nums.length];
		Arrays.fill(maxLength, 1);

		int max = 1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
				}
			}

			max = Math.max(max, maxLength[i]);
		}

		return max;
	}
}

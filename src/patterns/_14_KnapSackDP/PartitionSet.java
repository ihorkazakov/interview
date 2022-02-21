package patterns._14_KnapSackDP;

/**
 * Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */
public class PartitionSet {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n][target + 1];

        if (nums[0] <= target) dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            int num = nums[i];

            for (int j = 0; j <= target; j++) {
                // if target val is less then num, read from top
                // else
                // exclude this num : take from top (entire sum from the prev vals)
                // include this num : subtract value, and fetch prev value after subtracting curr val
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || (true && dp[i - 1][j - num]);
                }
            }
        }

        return dp[n - 1][target];
    }
}

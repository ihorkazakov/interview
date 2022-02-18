package company.MustDo75;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at
 * this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a
 * security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight
 * without alerting the police.
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        int sum1 = helper(nums, 0, n - 1);
        int sum2 = helper(nums, 1, n);

        return Math.max(sum1, sum2);
    }

    private int helper(int[] nums, int start, int end) {
        int pre = 0;
        int cur = 0;
        for (int i = start; i < end; i++) {
            int next = Math.max(nums[i] + pre, cur);
            pre = cur;
            cur = next;
        }

        return cur;
    }
}

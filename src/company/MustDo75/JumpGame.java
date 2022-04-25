package company.MustDo75;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents
 * your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        int last = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= last - i) {
                last = i;
            }
        }

        return last == 0;
    }
}

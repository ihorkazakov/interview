package patterns._02_TwoPointers;

/**
 * Given an array of sorted numbers and a target sum, find a pair in the
 * array whose sum is equal to the given target.
 *
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2 + 4 = 6
 */
public class PairWithTargetSum {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (target == sum) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}

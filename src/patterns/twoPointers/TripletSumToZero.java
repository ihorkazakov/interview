package patterns.twoPointers;

import java.util.*;

/**
 * Given an array of unsorted numbers, find all unique triplets in it that
 * add up to zero
 *
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 */
public class TripletSumToZero {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[low] + nums[high];
                if (sum == -nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if (sum < -nums[i]) {
                    low++;
                } else if (sum > -nums[i]) {
                    high--;
                }
            }
        }

        return new ArrayList<>(result);
    }
}

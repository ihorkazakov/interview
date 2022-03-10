package company.MustDo75;

import java.util.*;

/**
 *Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] +
 * nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {
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

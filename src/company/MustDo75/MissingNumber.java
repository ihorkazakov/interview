package company.MustDo75;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the
 * array.
 *
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it
 * does not appear in nums.
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        int expected = nums.length + 1;
        for (int i = 0; i < expected; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}

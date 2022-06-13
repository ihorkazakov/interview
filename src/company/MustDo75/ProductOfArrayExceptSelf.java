package company.MustDo75;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except
 * nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;

        for (int i = 1; i < n; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        int val = 1;

        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * val;
            val = val * nums[i];
        }

        return result;
    }
}

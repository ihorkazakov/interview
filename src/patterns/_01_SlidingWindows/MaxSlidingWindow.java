package patterns._01_SlidingWindows;

import java.util.LinkedList;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of
 * the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 *
 * Return the max sliding window.
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] max = new int[nums.length - k + 1];
        LinkedList<Integer> list = new LinkedList<>();

        if (nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            while (list.size() > 0 && nums[i] >= nums[list.getLast()]) {
                list.removeLast();
            }
            list.addLast(i);

            if (i - k + 1 >= 0) {
                max[i - k + 1] = nums[list.getFirst()];
            }

            if (i - k + 1 == list.getFirst()) {
                list.removeFirst();
            }
        }

        return max;
    }
}

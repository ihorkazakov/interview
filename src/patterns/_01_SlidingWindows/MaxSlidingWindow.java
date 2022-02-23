package patterns._01_SlidingWindows;

import java.util.PriorityQueue;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of
 * the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
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
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < k; i++) {
            maxHeap.add(new int[]{nums[i], i});
        }
        int[] res = new int[nums.length - k + 1];
        int index = 1;
        res[0] = maxHeap.peek()[0];

        for (int i = k; i < nums.length; i++) {
            maxHeap.add(new int[]{nums[i], i});
            while (maxHeap.peek()[1] <= i - k) {
                maxHeap.poll();
            }

            res[index++] = maxHeap.peek()[0];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(maxSlidingWindow(nums, 3));
    }
}

package patterns._12_TopKElements;

import java.util.PriorityQueue;

/**
 * Given an unsorted array of numbers, find Kth smallest number in it
 *
 * Input: [1, 5, 12, 2, 11, 5], K = 3
 * Output: 5
 * Explanation: The 3rd smallest number is '5', as the first two smaller
 * numbers are [1, 2]
 */
public class KthSmallestNumber {
    public static int findKthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int result = findKthSmallest(new int[]{1, 5, 12, 2, 11, 5}, 4);
        System.out.println(result);
    }
}

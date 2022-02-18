package company.amazon;

import java.util.PriorityQueue;

/**
 * bGiven an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
            System.out.println(minHeap.peek());
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }

        return minHeap.peek();
    }
}

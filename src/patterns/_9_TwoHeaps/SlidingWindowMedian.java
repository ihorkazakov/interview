package patterns._9_TwoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is
 * the mean of the two middle values.
 *
 * For examples, if arr = [2,3,4], the median is 3.
 * For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
 */
public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        var result = new double[len - k + 1];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < len; i++) {
            if (maxHeap.isEmpty() || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            balance(maxHeap, minHeap);

            if (i + 1 >= k) {
                if (maxHeap.size() == minHeap.size()) {
                    result[i + 1 - k] = minHeap.peek() / 2.0 + maxHeap.peek() / 2.0;
                } else {
                    result[i + 1 - k] = maxHeap.peek();
                }

                int numExitingTheWindow = nums[i + 1 - k];
                if (numExitingTheWindow <= maxHeap.peek()) {
                    maxHeap.remove(numExitingTheWindow);
                } else {
                    minHeap.remove(numExitingTheWindow);
                }
                balance(maxHeap, minHeap);
            }
        }

        return result;
    }

    private void balance(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap) {
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
}

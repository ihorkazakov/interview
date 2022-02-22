package patterns._12_TopKElements;

import java.util.*;

/**
 * Given an integer array nums and an integer k,
 * return the k most frequent elements. You may return the answer in any order.
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class TopKFrequentNumbers {
    public static int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));

        for (int i: map.keySet()) {
            heap.add(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 4, 4, 4};
        System.out.println(topKFrequent(nums, 2
        ));

    }
}

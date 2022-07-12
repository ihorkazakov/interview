package company.MustDo75;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		if (k == nums.length)
			return nums;

		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

		for (int i : map.keySet()) {
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
}

package patterns._13_KWayMerge;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given ‘M’ sorted arrays, find the K’th smallest number among all the
 * arrays.
 * <p>
 * Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4], K=5
 * Output: 4
 * Explanation: The 5th smallest number among all the arrays is 4, this c
 * an be verified from the merged
 * list of all the arrays: [1, 2, 3, 3, 4, 6, 6, 7, 8]
 */
public class KthSmallestInMSortedArrays {
    public static int findKthSmallest(List<Integer[]> list, int k) {
        PriorityQueue<Integer> maxHip = new PriorityQueue<>((a, b) -> b - a);
        for (Integer[] nums : list) {
            for (int i : nums) {
                if (maxHip.size() < k) {
                    maxHip.add(i);
                } else {
                    if (i < maxHip.peek()) {
                        maxHip.poll();
                        maxHip.add(i);
                    }
                }
            }
        }

        return maxHip.peek();
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[]{2, 6, 8};
        Integer[] l2 = new Integer[]{3, 6, 7};
        Integer[] l3 = new Integer[]{1, 3, 4};
        int result = findKthSmallest(Arrays.asList(l1, l2, l3), 5);
        System.out.println(result);
    }
}

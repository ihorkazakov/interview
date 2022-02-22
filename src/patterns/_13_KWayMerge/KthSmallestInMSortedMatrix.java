package patterns._13_KWayMerge;

import java.util.PriorityQueue;

/**
 * Given an n x n matrix where each of the rows and columns is sorted in ascending order,
 * return the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * You must find a solution with a memory complexity better than O(n2).
 *
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
 */
public class KthSmallestInMSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHip = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxHip.size() < k) {
                    maxHip.add(matrix[i][j]);
                } else {
                    if (matrix[i][j] < maxHip.peek()) {
                        maxHip.poll();
                        maxHip.add(matrix[i][j]);
                    }
                }
            }
        }

        return maxHip.peek();
    }
}

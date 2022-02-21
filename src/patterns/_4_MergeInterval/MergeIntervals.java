package patterns._4_MergeInterval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        LinkedList<int[]> result = new LinkedList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || interval[0] > result.getLast()[1]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(interval[1], result.getLast()[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

package company.MustDo75;

import java.util.ArrayList;
import java.util.List;

/**
 *You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of
 * the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that
 * represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have
 * any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] in : intervals) {
            if (in[1] < newInterval[0]) {
                list.add(in);
            } else if (newInterval[1] < in[0]) {
                list.add(newInterval);
                newInterval = in;
            } else {
                newInterval[0] = Math.min(newInterval[0], in[0]);
                newInterval[1] = Math.max(newInterval[1], in[1]);
            }
        }

        list.add(newInterval);

        return list.toArray(new int[list.size()][]);
    }
}

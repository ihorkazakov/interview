package patterns._09_TwoHeaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work
 * on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct
 * projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 *
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 *
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total
 * capital.
 *
 * Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
 *
 * Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
 * Output: 4
 * Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 * After finishing it you will obtain profit 1 and your capital becomes 1.
 * With capital 1, you can either start the project indexed 1 or the project indexed 2.
 * Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 * Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 */
public class MaximizedCapital {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<Integer> minHeapCapital = new PriorityQueue<>(n, Comparator.comparingInt(i -> capital[i]));
        PriorityQueue<Integer> maxHeapProfit = new PriorityQueue<>(n, Comparator.comparingInt(i -> -profits[i]));

        for (int i = 0; i < n; i++) {
            minHeapCapital.add(i);
        }

        for (int i = 0; i < k; i++) {
            // move all projects that can be completed with the available capital, from minHeap to maxHeap
            while (!minHeapCapital.isEmpty() && w >= capital[minHeapCapital.peek()]) {
                maxHeapProfit.add(minHeapCapital.poll());
            }

            // if no project can be completed with the available capital, then terminate
            if (maxHeapProfit.isEmpty())
                break;

            // choose the project with max profit
            w += profits[maxHeapProfit.poll()];
        }

        return w;
    }

}

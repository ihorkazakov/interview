package company.amazon;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb
 * one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return cost[0];
        }
        if (len == 2) {
            return Math.min(cost[0], cost[1]);
        }
        for (int i = 2; i < len; i++) {
            cost[i] = cost[i] + Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[len - 1], cost[len - 2]);
    }
}

package company.MustDo75;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates
 * where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return helper(candidates, 0, target, new ArrayList<>(), 0, new ArrayList<>());
    }

    private List<List<Integer>> helper(int[] candidates, int start, int target, List<Integer> path, int sum, List<List<Integer>> list) {
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] < start || sum + candidates[i] > target) {
                continue;
            }
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(candidates[i]);
            if (sum + candidates[i] == target) {
                list.add(newPath);
            } else {
                helper(candidates, candidates[i], target, newPath, sum + candidates[i], list);
            }
        }

        return list;
    }
}

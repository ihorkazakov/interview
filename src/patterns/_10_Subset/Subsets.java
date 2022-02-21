package patterns._10_Subset;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subset = new ArrayList<>();
        subset.add(new ArrayList<>());

        for (int num : nums) {
            int size = subset.size();
            for (int i = 0; i < size; i++) {
                List<Integer> set = new ArrayList<>(subset.get(i));
                set.add(num);
                subset.add(set);
            }
        }

        return subset;
    }
}

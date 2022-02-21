package patterns.slidingWindows;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of characters where each character represents a fruit tree,
 * you are given two baskets, and your goal is to put maximum number of
 * fruits in each basket. The only restriction is that each basket can have
 * only one type of fruit
 *
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 */
public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr){
        int start = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < arr.length; end++) {
            map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[start], map.getOrDefault(arr[start], 0) - 1);
                if (map.get(arr[start]) == 0) {
                    map.remove(arr[start]);
                }

                start++;
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(findLength(arr));
    }
}

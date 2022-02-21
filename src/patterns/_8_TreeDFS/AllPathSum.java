package patterns._8_TreeDFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals
 * targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to
 * child nodes).
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 */
public class AllPathSum {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        Queue<List<Integer>> sumList = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        sumList.add(list);

        int res = 0;
        while (!q.isEmpty()) {
            list = sumList.remove();
            root = q.remove();
            if (root.val == sum) {
                res++;
            }
            for (int val : list) {
                if (val + root.val == sum) {
                    res++;
                }
            }

            if (root.left != null) {
                q.add(root.left);
                List<Integer> child = new ArrayList<>();
                for (int val : list) {
                    child.add(val + root.val);
                }
                child.add(root.val);
                sumList.add(child);
            }

            if (root.right != null) {
                q.add(root.right);
                List<Integer> child = new ArrayList<>();
                for (int val : list) {
                    child.add(val + root.val);
                }
                child.add(root.val);
                sumList.add(child);
            }
        }

        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

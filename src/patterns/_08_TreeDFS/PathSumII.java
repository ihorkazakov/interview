package patterns._08_TreeDFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path
 * equals targetSum. Each path should be returned as a list of the node values, not node references.
 * <p>
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 * <p>
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> path = new ArrayList<>();
        findPath(root, sum, new ArrayList<>(), path);

        return path;
    }

    private void findPath(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> path) {
        if (root == null) {
            return;
        }

        curr.add(root.val);

        if (root.val == sum && root.left == null && root.right == null) {
            path.add(curr);
            return;
        } else {
            findPath(root.left, sum - root.val, new ArrayList<>(curr), path);
            findPath(root.right, sum - root.val, new ArrayList<>(curr), path);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}

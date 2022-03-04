package company.MustDo75;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node
 * can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 */
public class BinaryTreeMaximumPathSum {
    int result;

    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        getSum(root);
        return result;
    }

    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, getSum(root.left));
        int right = Math.max(0, getSum(root.right));
        result = Math.max(result, left + right + root.val);

        return Math.max(left, right) + root.val;
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

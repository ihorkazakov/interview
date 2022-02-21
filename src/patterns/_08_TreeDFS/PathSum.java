package patterns._08_TreeDFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree and an integer targetSum,
 * return true if the tree has a root-to-leaf path such that adding up all the
 * values along the path equals targetSum.
 *
 * A leaf is a node with no children.
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left == null && node.right == null && node.val == sum) {
                return true;
            }
            if (node.left != null) {
                node.left.val = node.val + node.left.val;
                q.offer(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val + node.right.val;
                q.offer(node.right);
            }
        }

        return false;
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

package dailyChalange.march;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, determine if it is a complete binary tree.
 *
 * In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Input: root = [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (i.e. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 */
public class _958_CheckCompletenessOfBinaryTree {
	public boolean isCompleteTree(TreeNode root) {
		if (root == null) {
			return true;
		}

		boolean nullNodeFound = false;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node == null) {
				nullNodeFound = true;
			} else {
				if (nullNodeFound) {
					return false;
				}
				q.offer(node.left);
				q.offer(node.right);
			}
		}

		return true;
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

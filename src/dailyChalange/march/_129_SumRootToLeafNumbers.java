package dailyChalange.march;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 *
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 */
public class _129_SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int sum = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.left == null && node.right == null) {
				sum += node.val;
			}

			int num = node.val * 10;

			if (node.left != null) {
				node.left.val += num;
				q.offer(node.left);
			}

			if (node.right != null) {
				node.right.val += num;
				q.offer(node.right);
			}
		}

		return sum;
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

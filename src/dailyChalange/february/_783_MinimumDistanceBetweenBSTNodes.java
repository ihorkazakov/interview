package dailyChalange.february;

/**
 * Given the root of a Binary Search Tree (BST), return the minimum difference between the values of any two different nodes in the tree.
 *
 * Input: root = [4,2,6,1,3]
 * Output: 1
 */
public class _783_MinimumDistanceBetweenBSTNodes {
	int minDistance = Integer.MAX_VALUE;
	TreeNode prevValue;

	public int minDiffInBST(TreeNode root) {
		inorderTraversal(root);
		return minDistance;
	}

	void inorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		inorderTraversal(root.left);
		if (prevValue != null) {
			minDistance = Math.min(minDistance, root.val - prevValue.val);
		}
		prevValue = root;
		inorderTraversal(root.right);
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

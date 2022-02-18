package company.MustDo75;

import company.amazon.BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary search tree,
 * and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        inorder(root, list);

        return list.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
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

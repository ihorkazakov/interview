package dailyChalange.december;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
 * You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
 *
 * Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.
 *
 * Example 1:
 *
 * Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * Output: [8,12,6,10,10,10]
 * Explanation: The tree is shown above.
 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * equals 1 + 1 + 2 + 2 + 2 = 8.
 * Hence, answer[0] = 8, and so on.
 */
public class _834_Sum_Of_DistancesInTree {
	private int[] res;
	private int[] count;
	private List<HashSet<Integer>> tree;

	public int[] sumOfDistancesInTree(int N, int[][] edges) {
		tree = new ArrayList<HashSet<Integer>>();
		res = new int[N];
		count = new int[N];
		for (int i = 0; i < N; ++i)
			tree.add(new HashSet<Integer>());
		for (int[] e : edges) {
			tree.get(e[0]).add(e[1]);
			tree.get(e[1]).add(e[0]);
		}
		postOrder(0, -1);
		preOrder(0, -1);
		return res;
	}

	public void postOrder(int root, int pre) {
		for (int i : tree.get(root)) {
			if (i == pre)
				continue;
			postOrder(i, root);
			count[root] += count[i];
			res[root] += res[i] + count[i];
		}
		count[root]++;
	}

	public void preOrder(int root, int pre) {
		for (int i : tree.get(root)) {
			if (i == pre)
				continue;
			res[i] = res[root] - count[i] + count.length - count[i];
			preOrder(i, root);
		}
	}
}

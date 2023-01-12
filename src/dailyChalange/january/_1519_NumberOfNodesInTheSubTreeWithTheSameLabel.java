package dailyChalange.january;

import java.util.*;

/**
 * You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges. The root of the tree is the node 0, and each node of the tree has a label which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).
 * The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.
 * Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.
 * A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.
 *
 * Example 1:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
 * Output: [2,1,1,1,1,1,1]
 * Explanation: Node 0 has label 'a' and its sub-tree has node 2 with label 'a' as well, thus the answer is 2. Notice that any node is part of its sub-tree.
 * Node 1 has a label 'b'. The sub-tree of node 1 contains nodes 1,4 and 5, as nodes 4 and 5 have different labels than node 1, the answer is just 1 (the node itself).
 */
public class _1519_NumberOfNodesInTheSubTreeWithTheSameLabel {
	public int[] countSubTrees(int n, int[][] edges, String labels) {
		Map<Integer, Set<Integer>> adj = new HashMap<>();
		for (int[] edge : edges) {
			int a = edge[0], b = edge[1];
			adj.computeIfAbsent(a, value -> new HashSet<Integer>()).add(b);
			adj.computeIfAbsent(b, value -> new HashSet<Integer>()).add(a);
		}
		// Store count of all alphabets of subtree of each node.
		int[][] counts = new int[n][26];
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			counts[i][labels.charAt(i) - 'a'] = 1;
			if (i != 0 && adj.get(i).size() == 1) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int node = q.poll();

			// Each node will have only one element which will be its parent.
			int parent = adj.get(node).stream().findFirst().get();
			// Remove current node from adjency list of parent node
			// so current node is not traversed again by parent node.
			// (due to this step, we remove all child nodes from a parent, at end parent node will only have its parent in adjacency list)
			adj.get(parent).remove(node);

			// Add counts of current node in parent's frequency array.
			for (int i = 0; i < 26; i++) {
				counts[parent][i] += counts[node][i];
			}

			// If parent adj size is 1, it has only it's parent in the adjacency list so,
			// it means current node is last child of parent so we insert it in queue now.
			if (parent != 0 && adj.get(parent).size() == 1) {
				q.offer(parent);
			}
		}

		int[] ans = new int[n];
		for (int i = 0; i < n; i++) {
			ans[i] = counts[i][labels.charAt(i) - 'a'];
		}

		return ans;
	}
}

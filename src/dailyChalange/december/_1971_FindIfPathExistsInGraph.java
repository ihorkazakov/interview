package dailyChalange.december;

import java.util.*;

/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 *
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.
 *
 * Example 1:
 *
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 */
public class _1971_FindIfPathExistsInGraph {
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		List<List<Integer>> list = new ArrayList();
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList());
		}

		for (int[] edge : edges) {
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}

		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		Set<Integer> seen = new HashSet<>();

		while (!stack.isEmpty()) {
			int cur = stack.pop();
			if (cur == destination) {
				return true;
			}
			if (seen.contains(cur)) {
				continue;
			}

			seen.add(cur);
			for (int i : list.get(cur)) {
				stack.push(i);
			}
		}

		return false;
	}
}

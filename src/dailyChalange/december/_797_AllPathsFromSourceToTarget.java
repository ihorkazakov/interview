package dailyChalange.december;

import java.util.*;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 *
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
public class _797_AllPathsFromSourceToTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>>  result = new ArrayList();
		Queue<List<Integer>> q = new LinkedList<>();
		q.add(Arrays.asList(0));

		int goal = graph.length - 1;
		while (!q.isEmpty()) {
			List<Integer> path = q.poll();
			int last = path.get(path.size() - 1);

			if (last == goal) {
				result.add(new ArrayList<>(path));
			} else {
				int[] neigh = graph[last];
				for (int n : neigh) {
					List<Integer> list = new ArrayList<>(path);
					list.add(n);
					q.add(list);
				}
			}
		}

		return result;
	}
}

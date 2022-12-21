package dailyChalange.december;

import java.util.*;

/**
 * We want to split a group of n people (labeled from 1 to n) into two groups of any size. Each person may dislike some other people, and they should not go into the same group.
 *
 * Given the integer n and the array dislikes where dislikes[i] = [ai, bi] indicates that the person labeled ai does not like the person labeled bi, return true if it is possible to split everyone into two groups in this way.
 *ч
 * Example 1:
 *
 * Input: n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4] and group2 [2,3].
 */
public class _886_PossibleBipartition {
	public boolean possibleBipartition(int N, int[][] dislikes) {
		if (dislikes.length == 0) {
			return true;
		}

		HashMap<Integer, List<Integer>> edges = new HashMap<>();
		int[] color = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			edges.put(i, new ArrayList<>());
		}
		for (int[] dislike : dislikes) {
			int a = dislike[0];
			int b = dislike[1];
			edges.get(a).add(b);
			edges.get(b).add(a);
		}

		for (int index = 1; index <= N; index++) {
			if (color[index] == 0) {
				q.add(index);
				color[index] = 1;

				while (!q.isEmpty()) {
					int size = q.size();
					for (int i = 0; i < size; i++) {
						int person = q.poll();
						int nextColor = color[person] == 1 ? 2 : 1;
						List<Integer> dislikePeople = edges.get(person);
						for (int j = 0; j < dislikePeople.size(); j++) {
							int dislikePerson = dislikePeople.get(j);
							if (color[dislikePerson] == color[person]) {
								return false;
							}
							if(color[dislikePerson] == 0) {
								color[dislikePerson] = nextColor;
								q.add(dislikePerson);
							}
						}
					}
				}
			}
		}

		return true;
	}
}

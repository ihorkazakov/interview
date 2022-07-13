package company.MustDo75;

import java.util.ArrayList;
import java.util.List;

/**
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
 * The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
 * The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
 *
 * Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
 */
public class PacificAtlanticWaterFlow {
	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		List<List<Integer>> ans = new ArrayList<>();

		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return ans;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];

		for (int j = 0; j < n; j++) {
			dfs(0, j, pacific, matrix, Integer.MIN_VALUE);

			dfs(m - 1, j, atlantic, matrix, Integer.MIN_VALUE);
		}

		for (int i = 0; i < m; i++) {

			dfs(i, 0, pacific, matrix, Integer.MIN_VALUE);

			dfs(i, n - 1, atlantic, matrix, Integer.MIN_VALUE);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pacific[i][j] && atlantic[i][j]) {
					List<Integer> indexes = new ArrayList<>();
					indexes.add(i);
					indexes.add(j);
					ans.add(indexes);
				}
			}
		}

		return ans;
	}

	private void dfs(int i, int j, boolean[][] canReach, int[][] matrix, int prevHeight) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || canReach[i][j] || matrix[i][j] < prevHeight) {
			return;
		}

		canReach[i][j] = true;

		dfs(i + 1, j, canReach, matrix, matrix[i][j]);
		dfs(i - 1, j, canReach, matrix, matrix[i][j]);
		dfs(i, j - 1, canReach, matrix, matrix[i][j]);
		dfs(i, j + 1, canReach, matrix, matrix[i][j]);
	}
}

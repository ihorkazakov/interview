package patterns;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * <p>
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * Input: grid = [
 * 	[1, 0, 0, 0],
 * 	[0, 0, 1, 1],
 * 	[1, 0, 1, 0],
 * 	[1, 0, 1, 1]
 * ]
 * Output: 5
 * Explanation: The answer is not 5, because the island must be connected 4-directionally.
 */
public class MaxAreaOfIsland {
	public static int maxAreaOfIsland(int[][] grid) {
		int result = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '0') {
					continue;
				}

				result = Math.max(result, helper(grid, i, j));
			}
		}

		return result;
	}

	private static int helper(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1) {
			return 0;
		}

		int result = 1;
		grid[i][j] = 0;
		result += helper(grid, i + 1, j);
		result += helper(grid, i - 1, j);
		result += helper(grid, i, j - 1);
		result += helper(grid, i, j + 1);

		return result;
	}

	public static void main(String[] args) {
		int[][] grid = {
			{ 1, 0, 0, 0 },
			{ 0, 0, 1, 1 },
			{ 1, 0, 1, 0 },
			{ 1, 0, 1, 1 }
		};

		System.out.println(maxAreaOfIsland(grid));
	}
}

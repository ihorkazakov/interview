package dailyChalange.january;

import java.util.Arrays;

/**
 * There are n cities connected by some number of flights.
 * You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 *
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
 * If there is no such route, return -1.
 *
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 */
public class _787_CheapestFlightsWithinKStops {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		// Distance from source to all other nodes.
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src] = 0;

		// Run only K+1 times since we want the shortest distance in K hops
		for (int i = 0; i <= k; i++) {
			// Create a copy of dist vector.
			int[] temp = Arrays.copyOf(dist, n);
			for (int[] flight : flights) {
				if (dist[flight[0]] != Integer.MAX_VALUE) {
					temp[flight[1]] = Math.min(temp[flight[1]], dist[flight[0]] + flight[2]);
				}
			}
			// Copy the temp vector into dist.
			dist = temp;
		}

		return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
	}
}

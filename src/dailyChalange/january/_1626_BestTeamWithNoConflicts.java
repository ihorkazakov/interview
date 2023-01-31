package dailyChalange.january;

import java.util.Arrays;

/**
 *You are the manager of a basketball team. For the upcoming tournament, you want to choose the team with the highest overall score. The score of the team is the sum of scores of all the players in the team.
 *
 * However, the basketball team is not allowed to have conflicts. A conflict exists if a younger player has a strictly higher score than an older player. A conflict does not occur between players of the same age.
 *
 * Given two lists, scores and ages, where each scores[i] and ages[i] represents the score and age of the ith player, respectively, return the highest overall score of all possible basketball teams.
 *
 * Example 1:
 *
 * Input: scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * Output: 34
 * Explanation: You can choose all the players.
 */
public class _1626_BestTeamWithNoConflicts {
	public int bestTeamScore(int[] scores, int[] ages) {
		int N = ages.length;
		int[][] ageScorePair = new int[N][2];

		for (int i = 0; i < N; i++) {
			ageScorePair[i][0] = scores[i];
			ageScorePair[i][1] = ages[i];
		}

		// Sort in ascending order of score and then by age.
		Arrays.sort(ageScorePair, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);

		int highestAge = 0;
		for (int i : ages) {
			highestAge = Math.max(highestAge, i);
		}
		int[] score = new int[highestAge + 1];

		int answer = Integer.MIN_VALUE;
		for (int[] ageScore : ageScorePair) {
			// Maximum score up to this age might not have all the players of this age.
			int currentBest = ageScore[0] + getMaxScore(score, ageScore[1]);
			// Update the tree with the current age and its best score.
			updateMaxScore(score, ageScore[1], currentBest);

			answer = Math.max(answer, currentBest);
		}

		return answer;
	}

	// Query tree to get the maximum score up to this age.
	private int getMaxScore(int[] score, int age) {
		int maxScore = Integer.MIN_VALUE;
		for (int i = age; i > 0; i -= i & (-i)) {
			maxScore = Math.max(maxScore, score[i]);
		}
		return maxScore;
	}

	// Update the maximum score for all the nodes with an age greater than the given age.
	private void updateMaxScore(int[] score, int age, int currentBest) {
		for (int i = age; i < score.length; i += i & (-i)) {
			score[i] = Math.max(score[i], currentBest);
		}
	}
}

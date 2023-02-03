package dailyChalange.february;

/**
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 */
public class _953_VerifyingAlienDictionary {
	public int[] map;

	public boolean isAlienSorted(String[] words, String order) {
		map = new int[26];
		for (int i = 0; i < order.length(); i++) {
			map[order.charAt(i) - 'a'] = i;
		}

		for (int i = 1; i < words.length; i++) {
			if (compare(words[i - 1], words[i]) > 0) {
				return false;
			}
		}

		return true;
	}

	public int  compare(String s1, String s2) {
		int i = 0;
		int j = 0;
		int val = 0;

		while (i < s1.length() && j < s2.length() && val == 0) {
			val = map[s1.charAt(i) - 'a'] - map[s2.charAt(j) - 'a'];
			i++;
			j++;
		}

		if (val == 0) {
			return s1.length() - s2.length();
		} else {
			return val;
		}
	}
}

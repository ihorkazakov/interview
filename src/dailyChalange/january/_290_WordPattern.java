package dailyChalange.january;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string s, find if s follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 *
 * Example 1:
 *
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 */
public class _290_WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] words = str.split(" ");
		if (words.length != pattern.length()) {
			return false;
		}

		Map<Character, String> map = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char letter = pattern.charAt(i);
			if (map.containsKey(letter)) {
				if (!map.get(letter).equals(words[i])) {
					return false;
				}
			} else {
				if (map.containsValue(words[i])) {
					return false;
				}
				map.put(letter, words[i]);
			}
		}

		return true;
	}
}

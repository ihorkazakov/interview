package dailyChalange.february;

/**
 * For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 *
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"

 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 */
public class _1071_GreatestCommonDivisorOfStrings {
	public String gcdOfStrings(String str1, String str2) {
		if (!(str1 + str2).equals(str2 + str1))  {
			return "";
		} else if (str1.equals(str2)) {
			return str1;
		} else if (str1.length() > str2.length()) {
			return gcdOfStrings(str1.substring(str2.length()), str2);
		} else {
			return gcdOfStrings(str2.substring(str1.length()), str1);
		}
	}
}

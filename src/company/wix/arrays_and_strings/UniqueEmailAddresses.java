package company.wix.arrays_and_strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.
 *
 * For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
 * If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.
 *
 * For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
 * If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.
 *
 * For example, "m.y+name@email.com" will be forwarded to "my@email.com".
 * It is possible to use both of these rules at the same time.
 *
 * Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * Output: 2
 * Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
 */
public class UniqueEmailAddresses {
	public int numUniqueEmails(String[] emails) {
		Set<String> seen = new HashSet<>();

		for (String email : emails) {
			seen.add(addEmail(email));
		}

		return seen.size();
	}

	private String addEmail(String s) {
		StringBuilder sb = new StringBuilder();
		boolean isLocal = true;
		int i = -1;
		while (i < s.length()) {
			i++;
			char letter = s.charAt(i);
			if (letter == '@') {
				break;
			} else if (!isLocal || letter == '.') {
				continue;
			} else if (letter == '+') {
				isLocal = false;
				continue;
			} else {
				sb.append(letter);
			}

		}
		sb.append(s.substring(i));

		return sb.toString();
	}
}

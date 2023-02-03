package dailyChalange.february;

/**
 * 	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 */
public class _6_ZigzagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1 || numRows >= s.length()) {
			return s;
		}

		char[] chars = s.toCharArray();
		StringBuilder[] zigzag = new StringBuilder[numRows];

		int row = 0;
		int step = 0;

		for (char c : chars) {
			if (zigzag[row] == null) {
				zigzag[row] = new StringBuilder();
			}
			zigzag[row].append(c);

			if (row == 0) {
				step = 1;
			} else if (row == numRows - 1) {
				step = -1;
			}

			row += step;
		}

		StringBuilder res = new StringBuilder(s.length());
		for (StringBuilder sb : zigzag) {
			res.append(sb);
		}

		return res.toString();
	}
}

package company.MustDo75;

/**
 * Given two integers a and b, return the sum of the two integers without using the operators + and -.
 *
 * Input: a = 1, b = 2
 * Output: 3
 */
public class SumOfTwoIntegers {
	public int getSum(int a, int b) {
		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}

		return a;
	}
}

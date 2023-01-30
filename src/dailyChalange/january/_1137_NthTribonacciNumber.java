package dailyChalange.january;

/**
 * The Tribonacci sequence Tn is defined as follows:
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 */
public class _1137_NthTribonacciNumber {
	public int tribonacci(int n) {
		if(n == 0)
			return 0;

		int n1=0, n2=1, n3=1;
		int count = 2, sum = 1;

		while(count < n){
			sum = n1 + n2 + n3;
			n1 = n2;
			n2 = n3;
			n3 = sum;
			count++;
		}

		return sum;
	}
}

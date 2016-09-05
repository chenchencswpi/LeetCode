package math;

public class ReverseInteger {

}

class ReverseIntegerSolution {
	/**
	 * Reverse an integer. For example, 123 -> 321, -123 -> 321. If there is an overflow after reverse, return 0.
	 * @param x
	 * @return
	 */
	public int reverse(int x) {
		boolean isPositive = true;
		if (x < 0) {
			isPositive = false;
			x = -x;
		}
		//make sure x is positive
		int res = 0;
		while (x > 0) {
			if (res > Integer.MAX_VALUE / 10) {
				return 0;
			}
			int current = x % 10;
			res = res * 10 + current;
			x /= 10;
		}
		
		if (!isPositive) {
			return -res;
		}
		return res;
	}
}

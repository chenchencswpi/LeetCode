package math;

/**
 * <a href="https://leetcode.com/problems/reverse-integer/">原题链接</a>
 * Reverse digits of an integer. For example, 123 -> 321, -123 -> -321.
 */

/**
 * 题目的意思是反转一个数字。做这种数字反转题大家一定要留意越界，越界，越界！重要的事情说三遍。
 * 如果存在越界可能，问面试官他期待的是什么。在这道题里，题目规定越界返回0就可以了。
 * @author cchen
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		boolean isPositive = true;
		if (x < 0) {
			isPositive = false;
			x = -x;
		}
		//保证x是正数
		int res = 0;
		while (x > 0) {
			if (res > Integer.MAX_VALUE / 10) { //为什么不写成res * 10 > Integer.MAX_VALUE呢？
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

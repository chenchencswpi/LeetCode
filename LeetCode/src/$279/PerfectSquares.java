package $279;

import java.util.Arrays;

public class PerfectSquares {
	public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {	//不需要遍历所有数字
                if (j * j == i) {
                    dp[i] = 1;
                } else if (j * j < i) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }
}

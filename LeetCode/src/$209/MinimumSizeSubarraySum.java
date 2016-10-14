package $209;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
        Integer res = null;
        int left = 0, right = 0, sum = 0;
        for (; left < nums.length; left++) {
            while (right < nums.length && sum < s) {
                sum += nums[right++];
            }
            if (sum >= s) {
                if (res == null) {
                    res = right - left;
                } else {
                    res = Math.min(res, right - left);
                }
            }
            sum -= nums[left];
        }
        if (res == null) {
            return 0;
        }
        return res;
    }
}

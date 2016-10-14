package $16;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int aim = target - nums[i];
                int curr = nums[left] + nums[right];
                if (Math.abs(aim - curr) < diff) {
                    diff = Math.abs(aim - curr);
                    res = nums[i] + curr;
                }
                if (curr < aim) {
                    left++;
                } else if (curr > aim) {
                    right--;
                } else {
                    return res;
                }
            }
        }
        return res;
    }
}

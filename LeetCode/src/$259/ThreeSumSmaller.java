package $259;

import java.util.Arrays;

public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] >= target - nums[i]) {
                    right--;
                } else {
                    count += right - left;
                    left++;
                }
            }
        }
        return count;
    }
}

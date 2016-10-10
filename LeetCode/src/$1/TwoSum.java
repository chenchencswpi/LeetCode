package $1;

import java.util.HashMap;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] res = {-1, -1};
		
		if (nums == null || nums.length < 2) {
			return res;
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				res[0] = map.get(target - nums[i]);
				res[1] = i;
				return res;
			} else {
				map.put(nums[i], i);
			}
		}
		
		return res;
    }
}

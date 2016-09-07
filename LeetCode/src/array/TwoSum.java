package array;

/**
 * <a href="https://leetcode.com/problems/two-sum/"></a>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.
 */
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

}

class TwoSumSolution {
	/**
	 * Brute force solution. Time complexity is O(n^2).
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) { 
		int[] res = {-1, -1};
		
		if (nums == null || nums.length < 2) {
			return res;
		}
		
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		
		return res;
	}
	
	/**
	 * Can you sort this array, then for each element, use binary search to find the complementary element?
	 * If we solve the problem in this way, the time complexity is O(nlgn).
	 * 
	 * No, we can't. If we sort the array, the index will be changed. Even if we find the complementary element's index,
	 * that's not the real index.
	 */
	
	/**
	 * Use hash table. The time complexity is O(n) since we only loop through the array once, and for each element, only
	 * O(1) time looking up the complementary element. However, we need O(n) space.
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target) {
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

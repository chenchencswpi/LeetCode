package array;

/**
 * <a href="https://leetcode.com/problems/remove-element/"></a>
 * Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
 */
import java.util.ArrayList;

public class RemoveElement {

}

class RemoveElementSolution {
	/**
	 * Use extra buffer.
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int number: nums) {
			if (number != val) {
				list.add(number);
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			nums[i] = list.get(i);
		}
		
		return nums.length;
	}
	
	/**
	 * Use O(1) space.
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement2(int[] nums, int val) {
		int left = 0, right = nums.length - 1;
		int newLength = 0;
		while (left <= right) {
			while (left < nums.length && nums[left] != val) {
				left++;
				newLength++;
			}
			while (right >= 0 && nums[right] == val) {
				right--;
			}
			if (left > right) {
				return newLength;
			}
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
			newLength++;
		}
		return newLength;
	}
}

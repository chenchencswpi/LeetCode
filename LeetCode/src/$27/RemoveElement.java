package $27;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
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

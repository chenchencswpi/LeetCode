package $80;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 3) {
            return nums.length;
        }
        int cursor = 1, position = 1, count = 1;
        while (position < nums.length) {
            if (nums[position] != nums[position - 1]) {
                nums[cursor++] = nums[position++];
                count = 1;
            } else {
                if (count == 1) {
                    nums[cursor++] = nums[position++];
                    count = 2;
                } else {
                    position++;
                }
            }
        }
        return cursor;
    }
}

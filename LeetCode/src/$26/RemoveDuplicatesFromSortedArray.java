package $26;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cursor = 1, pointer = 1;
        while (pointer < nums.length) {
            if (nums[pointer] != nums[pointer - 1]) {
                nums[cursor++] = nums[pointer++];
            } else {
                pointer++;
            }
        }
        return cursor;
    }
}

package $283;

public class MoveZeros {
	public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int cursor = 0, pointer = 0;
        while (pointer < nums.length) {
            if (nums[pointer] != 0) {
                int temp = nums[pointer];
                nums[pointer] = nums[cursor];
                nums[cursor] = temp;
                cursor++;
            }
            pointer++;
        }
    }
}

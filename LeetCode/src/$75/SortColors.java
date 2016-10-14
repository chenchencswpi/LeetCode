package $75;

public class SortColors {
	public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int red = -1, white = -1, blue = -1;
        for (int number: nums) {
            if (number == 2) {
                nums[++blue] = 2;
            } else if (number == 1) {
                nums[++blue] = 2;
                nums[++white] = 1;
            } else {
                nums[++blue] = 2;
                nums[++white] = 1;
                nums[++red] = 0;
            }
        }
    }
}

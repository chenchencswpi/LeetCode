package $167;

public class TwoSumIIInputArrayIsSorted {
	public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                int[] res = {left + 1, right + 1};
                return res;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
                while (left < right && numbers[left] == numbers[left - 1]) {
                    left++;
                }
            } else {
                right--;
                while (right > left && numbers[right] == numbers[right + 1]) {
                    right--;
                }
            }
        }
        return null;
    }
}

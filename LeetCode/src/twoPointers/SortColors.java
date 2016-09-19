package twoPointers;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of
 * the same color are adjacent, with the colors in the order red, white and blue.
 */
public class SortColors {
    /**
     * Typically we have multiple solutions regarding this problem. (Of course sorting cannot be included.)
     * 我们在第一次遍历数组的时候count一下0， 1， 2出现的次数，然后在第二次遍历的时候直接对数组进行赋值。
     * 但是题目知道咱们会这样耍赖，故意说只能遍历一次。那就老老实实的想想怎样才能一次遍历就能排好序呢？
     * @param nums: the input array
     */
    public void sortColors(int[] nums) {
        int zero = -1, one = -1, two = -1;
        int index = 0;
        while (index < nums.length) {
            if (nums[index] == 2) {
                two++;
            } else if (nums[index] == 1) {
                nums[++two] = 2;
                nums[++one] = 1;
            } else {
                nums[++two] = 2;
                nums[++one] = 1;
                nums[++zero] = 0;
            }
            index++;
        }
    }
}

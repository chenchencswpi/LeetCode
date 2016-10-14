package $349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (index1 > 0 && nums1[index1] == nums1[index1 - 1]) {
                index1++;
                continue;
            }
            if (index2 > 0 && nums2[index2] == nums2[index2 - 1]) {
                index2++;
                continue;
            }
            if (nums1[index1] == nums2[index2]) {
                res.add(nums1[index1]);
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        
        int[] numbers = new int[res.size()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = res.get(i);
        }
        return numbers;
    }
}

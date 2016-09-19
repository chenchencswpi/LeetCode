package $350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:
What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot 
load all elements into the memory at once?
 */




public class IntersectionOfTwoArraysII {
	
	public int[] intersect1(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number1: nums1) {
        	if (map.containsKey(number1)) {
        		map.put(number1, map.get(number1) + 1);
        	} else {
        		map.put(number1, 1);
        	}
        }
        
        List<Integer> list = new ArrayList<>();
        for (int number2: nums2) {
        	if (map.containsKey(number2)) {
        		list.add(number2);
        		int occur = map.get(number2);
        		if (occur == 1) {
        			map.remove(number2);
        		} else {
        			map.put(number2, occur - 1);
        		}
        	}
        }
        
        int[] res = new int[list.size()];
        int index = 0;
        for (int i: list) {
        	res[index++] = i;
        }
        
        return res;
    }
	
	public int[] intersect2(int[] nums1, int[] nums2) {
		List<Integer> res = new ArrayList<Integer>();
        
        int index1 = 0, index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
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
        
        int[] result = new int[res.size()];
        int index = 0;
        for (int number: res) {
            result[index++] = number;
        }
        
        return result;
	}
}



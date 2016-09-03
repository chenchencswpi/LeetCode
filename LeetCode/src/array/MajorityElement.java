package array;

import java.util.HashMap;

public class MajorityElement {

}

class MajorityElementSolution {
	/**
	 * Use hash table to track appearance of each element. After counting, loop through the table to return the element with
	 * appearance which is greater than n / 2.
	 * 
	 * The time complexity of this method is O(n), space is O(n).
	 * @param nums
	 * @return
	 */
	public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int element: nums) {
        	if (map.containsKey(element)) {
        		map.put(element, map.get(element) + 1);
        	} else {
        		map.put(element, 1);
        	}
        }
        
        for (int element: map.keySet()) {
        	if (map.get(element) > nums.length / 2) {
        		return element;
        	}
        }
        
        return -1;
    }
	
	/**
	 * The time complexity of this method is O(n), space is O(1).
	 * @param nums
	 * @return
	 */
	public int majorityElement2(int[] nums) {
		int current = nums[0], count = 1;
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == current) {
				count++;
			} else {
				count--;
				if (count < 0) {
					current = nums[i];
					count = 1;
				}
			}
		}
		
		return current;
	}
}

package $170;

import java.util.HashMap;

public class TwoSum {
	HashMap<Integer, Integer> map = new HashMap<>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)) {
	        map.put(number, map.get(number) + 1);
	    } else {
	        map.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int key: map.keySet()) {
	        int otherPart = value - key;
	        if (map.containsKey(otherPart)) {
	            if (otherPart == key && map.get(key) < 2) {
	                continue;
	            }
	            return true;
	        }
	    }
	    return false;
	}
}

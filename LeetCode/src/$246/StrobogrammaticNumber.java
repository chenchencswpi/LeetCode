package $246;

import java.util.HashMap;

public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('8', '8');
        map.put('9', '6');
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            char leftChar = num.charAt(left), rightChar = num.charAt(right);
            if (!map.containsKey(leftChar) || map.get(leftChar) != rightChar) {
                return false;
            }
            left++; right--;
        }
        return true;
    }
}

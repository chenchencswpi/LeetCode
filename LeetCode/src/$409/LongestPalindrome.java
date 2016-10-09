package $409;

import java.util.HashMap;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        boolean hasSingleDog = false;
        int length = 0;
        for (char c: map.keySet()) {
            int occur = map.get(c);
            if (occur % 2 != 0) {
                if (occur > 2) {
                    length+= occur - 1;
                }
                hasSingleDog = true;
            } else {
                length += occur;
            }
        }
        if (hasSingleDog) {
            length++;
        }
        return length;
    }
}

package $205;

import java.util.HashMap;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i), tChar = t.charAt(i);
            if (map.containsKey(sChar)) {
                if (map.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (map.containsValue(tChar)) {
                    return false;
                }
                map.put(sChar, tChar);
            }
        }
        return true;
    }
}

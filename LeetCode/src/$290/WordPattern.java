package $290;

import java.util.HashMap;

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        String[] tokens = str.split(" ");
        if (pattern.length() != tokens.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < tokens.length; i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (map.containsValue(tokens[i])) {	//这个字符串已经有别的字符代表了
                    return false;
                } else {
                    map.put(c, tokens[i]);
                }
            } else {
                if (map.get(c).equals(tokens[i]) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}

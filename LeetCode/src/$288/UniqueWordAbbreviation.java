package $288;

import java.util.HashMap;

public class UniqueWordAbbreviation {
	HashMap<String, String> map = new HashMap<>();

    public UniqueWordAbbreviation(String[] dictionary) {
        for (String dict: dictionary) {
            String abbr = getAbbr(dict);
            if (!map.containsKey(abbr)) {
                map.put(abbr, dict);
            } else {
                if (!map.get(abbr).equals(dict)) {
                    map.put(abbr, "");
                }
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !map.containsKey(abbr) || map.get(abbr).equals(word);
    }
    
    String getAbbr(String word) {
        int len = word.length();
        if (len < 3) {
            return word;
        }
        return "" + word.charAt(0) + (len - 2) + word.charAt(len - 1);
    }
}

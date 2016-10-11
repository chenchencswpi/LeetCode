package $49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string: strs) {
            String key = getKey(string);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(string);
        }
        for (List<String> list: map.values()) {
            res.add(list);
        }
        return res;
    }
    
    String getKey(String string) {
        char[] input = string.toCharArray();
        Arrays.sort(input);
        return new String(input);
    }
}

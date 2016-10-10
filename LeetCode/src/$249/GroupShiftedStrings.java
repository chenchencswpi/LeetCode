package $249;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string: strings) {
            String shifted = getShifted(string);
            if (!map.containsKey(shifted)) {
                map.put(shifted, new ArrayList<String>());
            }
            map.get(shifted).add(string);
        }
        for (String key: map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
    
    String getShifted(String s) {
        char[] string = s.toCharArray();
        int diff = 'a' - string[0] + 26;
        string[0] = 'a';
        for (int i = 1; i < string.length; i++) {
            string[i] = (char)('a' + (string[i] + diff - 'a') % 26);
        }
        return new String(string);
    }
}

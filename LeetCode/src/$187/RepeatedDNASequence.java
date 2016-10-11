package $187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequence {
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 10) {
            return res;
        }
        HashSet<String> set = new HashSet<>();
        HashSet<String> resSet = new HashSet<>();
        for (int i = 10; i <= s.length(); i++) {
            String string = s.substring(i - 10, i);
            if (set.contains(string)) {
                resSet.add(string);
            } else {
                set.add(string);
            }
        }
        for (String string: resSet) {
            res.add(string);
        }
        return res;
    }
}

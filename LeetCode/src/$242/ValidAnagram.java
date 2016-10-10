package $242;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
        if (s == null) {
            return t == null;
        }
        if (t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (char c: s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c: t.toCharArray()) {
            if (counts[c - 'a'] <= 0) {
                return false;
            } else {
                counts[c - 'a']--;
            }
        }
        return true;
    }
}

package $387;

public class FirstUniqueCharacterInAString {
	public int firstUniqChar(String s) {
        int[] happens = new int[26];
        for (char c: s.toCharArray()) {
            happens[c - 'a']++;
        }
        for (int index = 0; index < s.length(); index++) {
            if (happens[s.charAt(index) - 'a'] == 1) {
                return index;
            }
        }
        return -1;
    }
}

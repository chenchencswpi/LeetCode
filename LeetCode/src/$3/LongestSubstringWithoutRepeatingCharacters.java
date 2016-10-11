package $3;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[] visited = new boolean[256];
        int startIndex = 0, maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (visited[c]) {
                maxLength = Math.max(maxLength, i - startIndex);
                for (int j = startIndex; j < i; j++) {
                    char revert = s.charAt(j);
                    if (revert == c) {
                        startIndex = j + 1;
                        break;
                    }
                    visited[revert] = false;
                }
            } else {
                visited[c] = true;
            }
        }
        maxLength = Math.max(maxLength, s.length() - startIndex);
        return maxLength;
    }
}

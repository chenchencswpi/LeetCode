package stringProblems;

/**
 * Implement strStr(). Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * @author cchen
 *
 */
public class ImplementStrStrTest {
	public static void main(String[] args) {
		System.out.println("a".equals(null));
	}
}

class Solution1 {
	//time complexity is O(n2)
	public int strStr(String haystack, String needle) {
		//edge cases
		if (haystack == null || needle == null || needle.length() > haystack.length()) {
			return -1;
		}
		if (needle.length() == 0) {
			return 0;
		}
		//normal cases
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				if (needle.equals(haystack.substring(i, i + needle.length()))) {
					return i;
				}
			}
		}
		return -1;
	}
	
}

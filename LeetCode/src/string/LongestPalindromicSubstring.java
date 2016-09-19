package string;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">原文链接</a>
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 */

/**
 * 题目问的是对于一个字符串，让我们找出其中最长的那个回文子字符串。可以假设字符串的最长长度为1000，而且有且仅有一个最长的回文子字符串。
 */
public class LongestPalindromicSubstring {
	/**
	 * 首先是brute force.对于每个substring，我们来check它是不是回文。如果是，就去update一下。
	 * 时间复杂度为O(n^2).
	 */

	public String longestPalindrome(String s) {
        String longest = "";
        if (s == null || s.length() == 0) {
        	return longest;
        }
        
        for (int i = 0; i < s.length(); i++) {
        	for (int j = i; j < s.length(); j++) {
        		String curr = s.substring(i, j + 1);
        		if (isPalindromic(curr)) {
        			longest = longest.length() >= curr.length()? longest : curr;
        		}
        	}
        }
        
        return longest;
    }
	
	private boolean isPalindromic(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	/**
	 * 上面的做法，肯定要超时。面试官之所以问这种题，肯定是有比brute force更好的方法。到底什么解法更好呢？
	 * 首先我们来分析上面做法的不足之处。对于每个字符，我们都假设它可能是一个很长的回文字符串的开头，所以我们只能将所有以这个字符为开头的子字符串全部过一遍。
	 * 如果说要探究一种更好的解法，那就只能换一种思路了。既然不能从“一个字符是字符串的开头”这种角度来分析，那我们可以去试想，如果一个字符是一个回文字符串的
	 * 最中间位置，然后往两边开始拓展，看看到底能拓展多长，这不就方便很多了吗？
	 * 那么问题来了，这种做法只能保证我们得到的回文字符串是奇数长度，那偶数长度的字符串咋办？莫慌，我们可以将偶数长字符串的最中间的两个字符作为拓展的中心。对
	 * 于我们这种情况，可以将该字符和它下一个字符（如果两个字符是相同的）作为拓展中心即可！
	 * 话不多说，上代码。
	 */

	public String longestPalindrome2(String s) {
		String longest = "";
		
		if (s == null || s.length() == 0) {
			return longest;
		}
		
		for (int i = 0; i < s.length(); i++) {
			String curr1 = expandToLongest(s, i, i);
			longest = longest.length() >= curr1.length()? longest : curr1;
			if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
				String curr2 = expandToLongest(s, i, i + 1);
				longest = longest.length() >= curr2.length()? longest : curr2;
			}
		}
		
		return longest;
	}
	
	private String expandToLongest(String s, int center1Index, int center2Index) {
		while (center1Index > 0 && center2Index < s.length() - 1 && s.charAt(center1Index - 1) == s.charAt(center2Index + 1)) {
			center1Index--;
			center2Index++;
		}
		return s.substring(center1Index, center2Index + 1);
	}
}

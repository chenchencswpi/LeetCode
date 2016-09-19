package hashTable;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */

import java.util.Arrays;
import java.util.HashMap;

/**
 * 这道题目问的是给定一个字符串，让我们来寻找一个没有重复字符的最长子字符串。
 * 题目的做法比较直接：当我们在遍历这个字符串的时候，时刻保持记录出现过的字符的位置，如果当前字符在以前出现过，那么我们找到了一个candidate，
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 我们可以用哈希表来存储目前出现的字符以及其位置。当当前的字符已经出现过时，我们来计算目前的子字符串的长度，也就是哈希表的size，
     * 然后将遍历使用的index设置在第一个重复字符的后一位。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int longest = Integer.MIN_VALUE;

        int index = 0;
        while (index < s.length()) {
            char curr = s.charAt(index);
            if (map.containsKey(curr)) {
                longest = Math.max(longest, map.size());
                index = map.get(curr) + 1;
                map.clear();
            } else {
                map.put(curr, index);
                index++;
            }
        }
        longest = Math.max(longest, map.size());
        return longest;
    }
}

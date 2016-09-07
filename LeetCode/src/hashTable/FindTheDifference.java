package hashTable;

/**
 * ＜ａ　href="https://leetcode.com/problems/find-the-difference/">原文链接</a>
 * Given two strings s and t which consist of only lowercase letters.
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * Find the letter that was added in t.
 */

/**
 * 题目的意思是现在有两个字符串，字符串t是由字符串s经过随机打乱并且添加了一个字符后得到的，那么问这个添加了的字符是哪个？
 */

import java.util.Arrays;
import java.util.HashMap;

public class FindTheDifference {
    /**
     * 我们可以将这两个字符串排序，然后开始遍历进行一一比较。什么时候不一致了，就证明我们找到答案了。
     */

    public char findTheDifference2(String s, String t) {    //时间复杂度为O(nlgn)，空间复杂度为O(n)
        char[] sString = s.toCharArray();
        char[] tString = t.toCharArray();

        Arrays.sort(sString);
        Arrays.sort(tString);

        for (int i = 0; i < sString.length; i++) {
            if (sString[i] != tString[i]) {
                return tString[i];
            }
        }

        return tString[tString.length - 1];
    }

    /**
     * 我们可以用哈希表来记录在字符串s中每个元素出现的次数。在遍历字符串t的时候，如果发现有的字符这个哈希表并没有存，那么我们就发现
     * 了这个添加了的字符。
     */

    public char findTheDifference(String s, String t) { //时间复杂度为O(n)，空间复杂度为O(n)
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) + 1);
            } else {
                map.put(curr, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);

            if (map.containsKey(curr)) {
                int number = map.get(curr);

                if (number == 1) {
                    map.remove(curr);
                } else {
                    map.put(curr, number - 1);
                }
            } else {
                return curr;
            }
        }
        return '-';
    }
}

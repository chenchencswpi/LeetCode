package hashTable;

/**
 * <a href="https://leetcode.com/problems/palindrome-permutation/">原文链接</a>
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example: "code" -> False, "aab" -> True, "carerac" -> True.
 */

/**
 * 这道题是问一个字符串的变形会不会是回文。不管字符串如何变形，我们首先要探究的，是一个回文的字符串应该拥有怎样的特征？
 * 一般来讲，回文字符串有两种，一种是奇数长度的，例如: abcba，这样的字符串是以最中间的字符作为对称点，两边的字符以该对称点对称。
 * 另一种是偶数长度的，例如abba，这样的字符串直接镜面对称。那么我们可以看到这样的规律：作为一个回文字符串，最多只有一个字符会出现奇数次（
 * 长度为奇数的字符串），剩下的字符全部出现偶数次。
 */

import java.util.HashMap;

public class PalindromePermutation {
    /**
     * 我们可以用哈希表来记录每个字符出现的次数。
     */

    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        boolean foundSingleDog = false;

        for (Character key : map.keySet()) {
            if (map.get(key) % 2 != 0) {    //如果出现次数为奇数
                if (foundSingleDog) {
                    return false;
                }
                foundSingleDog = true;
            }
        }

        return true;
    }

    /**
     * 除了哈希表以外，我们还可以用别的数据结构，例如一个数组，来存储每个字母出现的次数。但是注意要和面试官核对一下字符串的字符集是什么？
     * 如果面试官说字符串只由a-z的小写字母组成，那么我们就可以定义一个长度为26的数组来记录就ok了。
     * 在这里我们假设字符集为ascii。
     */

    public boolean canPermutePalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }

        int[] counts = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            counts[current]++;
        }

        boolean foundSingleDog = false;

        for (int count : counts) {
            if (count % 2 != 0) {
                if (foundSingleDog) {
                    return false;
                }
                foundSingleDog = true;
            }
        }

        return true;
    }

}

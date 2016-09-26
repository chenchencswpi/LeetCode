package stringProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Given a string, we can shift each of its letter to its successive letter, for example: "abc -> bcd".
//Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence
public class GroupShiftedStringsTest {
	public static void main(String[] args) {
		String[] input = {"abc","bcd","acef","xyz","az","ba","a","z"};
		System.out.println(new Solution2().getNewString("bcd"));
	}
}

class Solution2 {
	public static List<List<String>> groupStrings(String[] strings) {
		if (strings == null) {
			return null;
		}
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		List<List<String>> res = new ArrayList<List<String>>();
		for (String s: strings) {
			String mutation = getNewString(s);
			if (map.containsKey(mutation)) {
				map.get(mutation).add(s);
			} else {
				List<String> temp = new ArrayList<String>();
				temp.add(s);
				map.put(mutation, temp);
			}
		}
		for (List<String> list: map.values()) {
			res.add(list);
		}
		return res;
	}
	
	static char getNthCharacter(char c, int n) {
		return (char)((c - 'a' + n) % 26 + 'a');
	}
	
	static String getNewString(String s) {
		char[] input = s.toCharArray();
		int offset = 'a' - s.charAt(0) + 26;
		input[0] = 'a';
		for (int i = 1; i < input.length; i++) {
			input[i] = getNthCharacter(input[i], offset);
		}
		return new String(input);
	}
}

package stringProblems;

//Write a function that takes a string as input and returns the string reversed.
public class ReverseStringTest {

}

class Solution {
	//2 pointers approach
	public String reverseString(String s) {
		if (s == null || s.length() < 2) {
			return s;
		}
		int left = 0, right = s.length() - 1;
		//since String is immutable, we put it into char array
		char[] input = s.toCharArray();
		while (left < right) {
			char temp = input[left];
			input[left++] = input[right];
			input[right--] = temp;
		}
		return new String(input);
	}
}
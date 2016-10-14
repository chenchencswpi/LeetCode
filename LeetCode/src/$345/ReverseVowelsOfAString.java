package $345;

import java.util.HashSet;

public class ReverseVowelsOfAString {
	public String reverseVowels(String s) {
        if (s == null) {
            return s;
        }
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] input = s.toCharArray();
        int left = 0, right = input.length - 1;
        while (left < right) {
            if (!vowels.contains(input[left])) {
                left++;
                continue;
            }
            if (!vowels.contains(input[right])) {
                right--;
                continue;
            }
            char temp = input[left];
            input[left] = input[right];
            input[right] = temp;
            left++; right--;
        }
        return new String(input);
    }
}

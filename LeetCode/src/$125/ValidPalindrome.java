package $125;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!isValid(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isValid(s.charAt(right))) {
                right--;
                continue;
            }
            if (!isEqual(s.charAt(left), s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
    
    boolean isEqual(char left, char right) {
        if (left == right) {
            return true;
        }
        if (left <= 90 && left >= 65) {
            return right == left + 32;
        }
        if (left >= 97) {
            return right == left - 32;
        }
        return false;
    }
}

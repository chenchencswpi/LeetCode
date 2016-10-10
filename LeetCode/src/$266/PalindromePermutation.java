package $266;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
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

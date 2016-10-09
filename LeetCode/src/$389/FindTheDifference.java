package $389;

import java.util.Arrays;

public class FindTheDifference {
	public char findTheDifference(String s, String t) {
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
}

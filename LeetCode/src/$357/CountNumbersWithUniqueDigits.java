package $357;

import java.util.ArrayList;
import java.util.List;

public class CountNumbersWithUniqueDigits {
	public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        List<String> res = new ArrayList<>();
        process(res, "", 0, n);
        return res.size();
        
    }
    
    void process(List<String> list, String prefix, int currentLength, int limitLength) {
        if (currentLength >= limitLength) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (!startWithZero(prefix) && !exsiting(prefix, i)) {
                prefix += i;
                list.add(prefix);
                process(list, prefix, currentLength + 1, limitLength);
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
    }
    
    boolean exsiting(String string, int number) {
        for (int i = 0; i < string.length(); i++) {
            int curr = string.charAt(i) - '0';
            if (curr == number) {
                return true;
            }
        }
        return false;
    }
    
    boolean startWithZero(String string) {
        if (string.length() > 0 && string.charAt(0) == '0') {
            return true;
        }
        return false;
    }
}

class CountNumbersWithUniqueDigits2 {
	public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 9;
        int counter = 9;
        for (int i = 2; i <= n; i++) {
            if (counter == 0) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] * (counter--);
            }
        }
        int res = 0;
        for (int count: dp) {
            res += count;
        }
        return res;
    }
}
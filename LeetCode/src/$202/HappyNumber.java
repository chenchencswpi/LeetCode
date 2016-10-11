package $202;

import java.util.HashSet;

public class HappyNumber {
	public boolean isHappy(int n) {
        if (n < 1) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = getNext(n);
        }
        return true;
    }
    
    int getNext(int number) {
        int res = 0;
        while (number > 0) {
            int digit = number % 10;
            res += digit * digit;
            number /= 10;
        }
        return res;
    }
}

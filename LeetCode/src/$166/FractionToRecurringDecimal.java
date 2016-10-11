package $166;

import java.util.HashMap;

public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        long numer = numerator, denom = denominator;
        String res = "";
        if ((numer < 0) ^ (denom < 0)) {
            numer = Math.abs(numer);
            denom = Math.abs(denom);
            res += "-";
        }
        res += numer / denom;
        long remaining = numer % denom;
        if (remaining == 0) {
            return res;
        }
        res += ".";
        HashMap<Long, Integer> map = new HashMap<>();
        while (remaining != 0) {
            remaining *= 10;
            if (!map.containsKey(remaining)) {
                map.put(remaining, res.length());
                res += remaining / denom;
                remaining %= denominator;
            } else {
                String repeating = res.substring(map.get(remaining), res.length());
                res = res.substring(0, map.get(remaining)) + "(" + repeating + ")";
                break;
            }
        }
        return res;
    }
}

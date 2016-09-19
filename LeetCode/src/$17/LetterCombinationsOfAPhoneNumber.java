package $17;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] array = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
            "tuv", "wxyz"};
        process(res, array, digits, "", 0);
        return res;
    }
    
    void process(List<String> res, String[] array, String digits, String prefix, int currentIndex) {
        if (currentIndex == digits.length()) {
            res.add(prefix);
            return;
        }
        int curr = digits.charAt(currentIndex) - '0';
        for (int i = 0; i < array[curr].length(); i++) {
            prefix += array[curr].charAt(i);
            process(res, array, digits, prefix, currentIndex + 1);
            //下面这步非常关键，将上一步加入的字符给删掉。例如当前数字为'2'，对应字符串为“abc”，那么将a加入到前缀处理完之后要将它删掉，
            //这样b就能在插入前缀里。也可以直接写成process(res, array, digits, prefix + array[curr].charAt(i),currentIndex + 1).
            prefix = prefix.substring(0, prefix.length() - 1); 
        }
    }
}

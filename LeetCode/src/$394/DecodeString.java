package $394;

import java.util.ArrayList;
import java.util.List;

public class DecodeString {
	public String decodeString(String s) {
        String res = "";
        if (s == null || s.length() == 0) {
            return s;
        }
        return process(s);
    }
	
	String process(String s1) {		
        List<String> list = getOneLevel(s1);
        String s= "";
        if (list.size() == 1) {
            return list.get(0);
        } else {
            for (String string: list) {
                s += getOneLevel(string);
            }
        }
        return s;
    }
	
	List<String> getOneLevel(String s) {		//dfs方法：只剥开一层
        List<String> list = new ArrayList<String>();
        int index = 0;
        String curr = "";
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c >= '0' && c <= '9') {		//如果当前是个数字，那我们需要接着往后读，读完整个数字
                if (curr.length() > 0) {
                    list.add(curr);
                    curr = "";
                }
                int number = c - '0';
                while (s.charAt(index + 1) >= '0' && s.charAt(index + 1) <= '9') {
                    index++;
                    number = number * 10 + s.charAt(index) - '0';
                }
                int leftCount = 1;		//代表有几个左中括号
                index += 2;		//数字的后面肯定是个左中括号，所以直接忽略，跳到下一个
                while (leftCount > 0) {
                    char c2 = s.charAt(index++);
                    if (c2 == '[') {
                        leftCount++;
                        curr += c2;
                    } else if (c2 == ']') {
                        leftCount--;
                        if (leftCount > 0) {
                            curr += c2;
                        } else {
                            break;
                        }
                    } else {
                        curr += c2;
                    }
                }
                for (int i = 1; i <= number; i++) {
                    list.add(curr);
                }
                curr = "";
            } else {
                curr += c;
                index++;
            }
        }
        if (curr.length() > 0) {		//到最后一定要检查有没有落下字符串
            list.add(curr);
        }
        return list;
    }
}

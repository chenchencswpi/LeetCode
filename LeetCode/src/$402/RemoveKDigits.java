package $402;

import java.util.Stack;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
        if (num == null || k >= num.length()) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char curr = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() > curr && num.length() - i > num.length() - k - stack.size()) {
                stack.pop();
            }
            if (stack.size() < num.length() - k) {
                stack.push(curr);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}

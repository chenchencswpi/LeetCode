package $385;

import java.util.List;
import java.util.Stack;

public class MiniParser {
	//[123, [456]]
	public NestedInteger deserialize(String s) {
        Stack<NestedInteger> stack = new Stack<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	switch(c) {
        		case '[':
        			stack.push(new NestedInteger());
        			break;
        		case ']':
        			if (!temp.equals("")) {
        				stack.peek().add(new NestedInteger(Integer.valueOf(temp)));
        				temp = "";
        			}
        			NestedInteger top = stack.pop();
        			if (!stack.isEmpty()) {
        				stack.peek().add(top);
        			} else {
        				return top;
        			}
        			break;
        		case ',':
        			if (!temp.equals("")) {
        				stack.peek().add(new NestedInteger(Integer.valueOf(temp)));
        				temp = "";
        			}
        			break;
        		default:
        			temp += c;
        	}
        }
        if (!temp.equals("")) {
        	return new NestedInteger(Integer.valueOf(temp));
        }
        return null;
    }
}










class NestedInteger {
	//Constructor initializes an empty nested list.
	public NestedInteger(){}
	//Constructor initializes a single integer.
	public NestedInteger(int value){}
	//@return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger(){return false;}
	//@return the single integer that this NestedInteger holds, if it holds a single integer
	//Return null if this NestedInteger holds a nested list
	public Integer getInteger(){return null;}
	//@Set this NestedInteger to hold a single integer.
	public void setInteger(int value){}
	//@Set this NestedInteger to hold a nested list and adds a nested integer to it.
	public void add(NestedInteger ni){};
	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList(){return null;}
}
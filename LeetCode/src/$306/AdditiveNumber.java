package $306;

public class AdditiveNumber {
	public boolean isAdditiveNumber(String num) {
		for (int i = 0; i < num.length(); i++) {
			for (int j = i + 1; j < num.length() - i - 1; j++) {
				String num1 = num.substring(0, i + 1);
				String num2 = num.substring(i + 1, j + 1);
				if (valid(j + 1, num, num1, num2)) {
					return true;
				}
			}
		}
		return false;
	}
	
	boolean valid(int startIndex, String num, String first, String second) {
		if (startIndex == num.length()) {
			return true;
		}
		if (startWithZero(first) || startWithZero(second)) {
			return false;
		}
		String sum = getSum(first, second);
		if (startIndex + sum.length() > num.length()) {
			return false;
		}
		String origin = num.substring(startIndex, startIndex + sum.length());
		if (startWithZero(origin) || !origin.equals(sum)) {
			return false;
		}
		return valid(startIndex + sum.length(), num, second, sum);
	}
	
	String getSum(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int index1 = num1.length() - 1, index2 = num2.length() - 1;
		while (index1 >= 0 || index2 >= 0) {
			if (index1 >= 0) {
				carry += num1.charAt(index1--) - '0';
			}
			if (index2 >= 0) {
				carry += num2.charAt(index2--) - '0';
			}
			sb.insert(0, carry % 10);
			carry /= 10;
		}
		if (carry != 0) {
			sb.insert(0, carry);
		}
		return sb.toString();
	}
	
	boolean startWithZero(String num) {
		if (num.length() > 1 && num.charAt(0) == '0') {
			return true;
		}
		return false;
	}
}

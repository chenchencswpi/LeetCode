package $136;

public class SingleNumber {
	public int singleNumber(int[] nums) {
        int res = 0;
        for (int number: nums) {
            res ^= number;
        }
        return res;
    }
}

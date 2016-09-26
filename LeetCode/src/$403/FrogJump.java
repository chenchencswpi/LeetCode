package $403;

import java.util.Arrays;

public class FrogJump {
	public boolean canCross1(int[] stones) {
        if (stones == null || stones.length < 2) {
            return true;
        }
        if (stones[1] != 1) {
            return false;
        }
        return process(stones, 1, 1);
    }
    
    boolean process(int[] stones, int currIndex, int lastJump) {
        if (currIndex == stones.length - 1) {
            return true;
        }
        for (int currJump = lastJump - 1; currJump <= lastJump + 1; currJump++) {
            if (currJump != 0) {
                int nextIndex = Arrays.binarySearch(stones, currIndex + 1, stones.length, stones[currIndex] + currJump);
                if (nextIndex > 0) {
                    if (process(stones, nextIndex, currJump)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

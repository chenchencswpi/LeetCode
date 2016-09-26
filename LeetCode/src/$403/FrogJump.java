package $403;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
    
    public boolean canCross2(int[] stones) {
    	if (stones == null || stones.length < 2) {
    		return true;
    	}
    	if (stones[1] != 1) {
    		return false;
    	}
    	Queue<Entry> queue = new LinkedList<>();
    	queue.offer(new Entry(1, 1));
    	while (!queue.isEmpty()) {
    		Entry currentPosition = queue.poll();
    		if (currentPosition.index == stones.length - 1) {
    			return true;
    		}
    		for (int k = currentPosition.lastJumpUnits - 1; k <= currentPosition.lastJumpUnits + 1; k++) {
    			int nextIndex = Arrays.binarySearch(stones, currentPosition.index + 1, stones.length, 
    					stones[currentPosition.index] + k);
    			if (nextIndex > 0) {
    				queue.offer(new Entry(nextIndex, k));
    			}
    		}
    	}
    	return false;
    }
    
    class Entry {
    	int index;
    	int lastJumpUnits;
    	public Entry(int index, int lastJumpUnits) {
    		this.index = index;
    		this.lastJumpUnits = lastJumpUnits;
    	}
    }
}

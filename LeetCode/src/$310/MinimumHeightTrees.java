package $310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	map.put(i, new HashSet<Integer>());
        }
        for (int[] edge: edges) {
        	map.get(edge[0]).add(edge[1]);
        	map.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
        	if (map.get(i).size() == 1) {
        		res.add(i);
        	}
        }
        while (n > 2) {
        	n -= res.size();
        	List<Integer> nextRound = new ArrayList<>();
        	for (int currLeaf: res) {
        		for (int candidate: map.get(currLeaf)) {
        			map.get(candidate).remove(currLeaf);
        			if (map.get(candidate).size() == 1) {
        				nextRound.add(candidate);
        			}
        		}
        	}
        	res = nextRound;
        }
        return res;
    }
}

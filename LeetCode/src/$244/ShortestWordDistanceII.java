package $244;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistanceII {
	HashMap<String, List<Integer>> map = new HashMap<>();

    public ShortestWordDistanceII(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int index1 = 0, index2 = 0;
        while (index1 < list1.size() && index2 < list2.size()) {
            minDistance = Math.min(minDistance, Math.abs(list1.get(index1) - list2.get(index2)));
            if (list1.get(index1) <= list2.get(index2)) {
                index1++;
            } else {
                index2++;
            }
        }
        return minDistance;
    }
}

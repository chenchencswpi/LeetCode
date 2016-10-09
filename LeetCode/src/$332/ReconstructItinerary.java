package $332;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<>();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket: tickets) {
            if (!map.containsKey(ticket[0])) {
                map.put(ticket[0], new PriorityQueue<String>());
            }
            map.get(ticket[0]).add(ticket[1]);
        }
        dfs(res, map, "JFK");
        return res;
    }
    
    void dfs(LinkedList<String> res, HashMap<String, PriorityQueue<String>> map, String curr) {
        PriorityQueue<String> queue = map.get(curr);
        while (queue != null && !queue.isEmpty()) {
            dfs(res, map, queue.poll());
        }
        res.addFirst(curr);
    }
}

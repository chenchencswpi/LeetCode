package $261;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphValidTree {
	public boolean validTreeDFS(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        if (!dfs(0, -1, map, visited)) {
            return false;
        }
        for (boolean b: visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
    
    boolean dfs(int curr, int parent, HashMap<Integer, List<Integer>> map, boolean[] visited) {
        if (visited[curr]) {
            return false;
        }
        visited[curr] = true;
        for (Integer child: map.get(curr)) {
            if (child != parent && !dfs(child, curr, map, visited)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean validTreeBFS(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }
        for (int[] edge: edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()) {
            Integer curr = queue.poll();
            if (visited[curr]) {
                return false;
            }
            visited[curr] = true;
            for (Integer child: map.get(curr)) {
                if (!visited[child]) {
                    queue.offer(child);
                }
            }
        }
        for (boolean b: visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}

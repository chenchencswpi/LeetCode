package $323;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
	public int countComponentsDFS(int n, int[][] edges) {
        List[] neighbors = new List[n];
        for (int i = 0; i < n; i++) {
            neighbors[i] = new ArrayList<Integer>();
        }
        for (int[] edge: edges) {
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, neighbors, visited);
            }
        }
        
        return count;
    }
    
    void dfs(int curr, List<Integer>[] neighbors, boolean[] visited) {
        if (visited[curr]) {
            return;
        }
        visited[curr] = true;
        for (int neighbor: neighbors[curr]) {
            dfs(neighbor, neighbors, visited);
        }
    }
    
    public int countComponentsBFS(int n, int[][] edges) {
        List[] neighbors = new List[n];
        for (int i = 0; i < n; i++) {
            neighbors[i] = new ArrayList<Integer>();
        }
        for (int[] edge: edges) {
            neighbors[edge[0]].add(edge[1]);
            neighbors[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                bfs(i, neighbors, visited);
            }
        }
        return res;
    }
    
    void bfs(int curr, List<Integer>[] neighbors, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(curr);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            visited[now] = true;
            for (int neighbor: neighbors[now]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                }
            }
        }
    }
}

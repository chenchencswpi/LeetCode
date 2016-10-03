package $133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
	public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.poll();
            for (UndirectedGraphNode neighbor: curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newNeighbor);
                    queue.offer(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }
	
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        dfs(node, map);
        return newNode;
    }
    
    void dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
        for (UndirectedGraphNode neighbor: node.neighbors) {
            if (!map.containsKey(neighbor)) {
                map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                dfs(neighbor, map);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
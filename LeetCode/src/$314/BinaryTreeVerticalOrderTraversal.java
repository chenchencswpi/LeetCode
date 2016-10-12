package $314;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        int minLeft = 0, maxRight = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> columnQueue = new LinkedList<>();
        nodeQueue.offer(root);
        columnQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int column = columnQueue.poll();
            minLeft = Math.min(minLeft, column);
            maxRight = Math.max(maxRight, column);
            if (!map.containsKey(column)) {
                map.put(column, new ArrayList<Integer>());
            }
            map.get(column).add(node.val);
            if (node.left != null) {
                nodeQueue.offer(node.left);
                columnQueue.offer(column - 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                columnQueue.offer(column + 1);
            }
        }
        for (int i = minLeft; i <= maxRight; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int x) {
		val = x;
	}
}

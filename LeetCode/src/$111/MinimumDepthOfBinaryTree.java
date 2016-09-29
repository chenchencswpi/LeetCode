package $111;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
	public int minDepthDfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepthDfs(root.left), rightDepth = minDepthDfs(root.right);
        if (root.left != null && root.right != null) {
            return 1 + Math.min(leftDepth, rightDepth);
        } else if (root.left == null) {
            return 1 + rightDepth;
        } else {
            return 1 + leftDepth;
        }
    }
	
	public int minDepthBfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		Queue<Integer> depth = new LinkedList<>();
		nodeQueue.offer(root);
		depth.offer(1);
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.poll();
			int currentDepth = depth.poll();
			if (node.left == null && node.right == null) {
				return currentDepth;
			}
			if (node.left != null) {
				nodeQueue.offer(node.left);
				depth.offer(currentDepth + 1);
			}
			if (node.right != null) {
				nodeQueue.offer(node.right);
				depth.offer(currentDepth + 1);
			}
		}
		return 0;
	}
}

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode (int x) {
		val = x;
	}
}

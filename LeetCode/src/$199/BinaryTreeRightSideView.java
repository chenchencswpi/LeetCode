package $199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        process(res, root, 0);
        return res;
    }
    
    void process(List<Integer> res, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level >= res.size()) {
            res.add(node.val);
        }
        process(res, node.right, level + 1);
        process(res, node.left, level + 1);
    }
    
    public List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        nodeQueue.offer(root);
        levels.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode current = nodeQueue.poll();
            int currentLevel = levels.poll();
            if (currentLevel >= res.size()) {
                res.add(current.val);
            }
            if (current.right != null) {
                nodeQueue.offer(current.right);
                levels.offer(currentLevel + 1);
            }
            if (current.left != null) {
                nodeQueue.offer(current.left);
                levels.offer(currentLevel + 1);
            }
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
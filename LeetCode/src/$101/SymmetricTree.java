package $101;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }
    
    boolean isSame(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return node2 == null;
        }
        if (node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return isSame(node1.left, node2.right) && isSame(node1.right, node2.left);
    }
    
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null) {
            return root.right == null;
        }
        if (root.right == null) {
            return false;
        }
        Queue<TreeNode> leftNodeQueue = new LinkedList<>();
        Queue<TreeNode> rightNodeQueue = new LinkedList<>();
        leftNodeQueue.offer(root.left);
        rightNodeQueue.offer(root.right);
        while (!leftNodeQueue.isEmpty() && !rightNodeQueue.isEmpty()) {
            TreeNode left = leftNodeQueue.poll(), right = rightNodeQueue.poll();
            if (left.val != right.val) {
                return false;
            }
            if (left.left != null) {
                leftNodeQueue.offer(left.left);
            }
            if (right.right != null) {
                rightNodeQueue.offer(right.right);
            }
            if (left.right != null) {
                rightNodeQueue.offer(left.right);
            }
            if (right.left != null) {
                leftNodeQueue.offer(right.left);
            }
        }
        if (!leftNodeQueue.isEmpty() || !rightNodeQueue.isEmpty()) {
            return false;
        }
        return true;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) {
		val = x;
	}
}
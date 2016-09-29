package $111;

public class MinimumDepthOfBinaryTree {
	public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left), rightDepth = minDepth(root.right);
        if (root.left != null && root.right != null) {
            return 1 + Math.min(leftDepth, rightDepth);
        } else if (root.left == null) {
            return 1 + rightDepth;
        } else {
            return 1 + leftDepth;
        }
    }
}

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode (int x) {
		val = x;
	}
}

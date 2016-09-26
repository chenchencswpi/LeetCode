package $404;

public class SumOfLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		return getSum(root, false);
	}
	
	int getSum(TreeNode node, boolean isLeft) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			if (isLeft) {
				return node.val;
			}
		}
		return getSum(node.left, true) + getSum(node.right, false);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
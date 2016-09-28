package $124;

public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        process(root);
        return max;
    }
    
    int process(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = process(node.left), right = process(node.right);
        int currentMax = Math.max(node.val, node.val + Math.max(left, right));
        max = Math.max(max, Math.max(currentMax, node.val + left + right));
        return currentMax;
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
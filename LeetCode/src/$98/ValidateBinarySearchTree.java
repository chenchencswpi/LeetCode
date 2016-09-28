package $98;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        return process(root, null, null);
    }
    
    boolean process(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if (min != null && min >= node.val) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        return process(node.left, min, node.val) && process(node.right, node.val, max);
    }
}


class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode (int x) {
		val = x;
	}
}
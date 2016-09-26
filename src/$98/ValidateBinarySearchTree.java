package $98;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return process(root, null, null);
    }
    
    boolean process(TreeNode node, Integer min, Integer max) {
        if (min != null && node.val <= min) {
            return false;
        }
        if (max != null && node.val >= max) {
            return false;
        }
        if (node.left != null) {
            if (!process(node.left, min, node.val)) {
                return false;
            }
        }
        if (node.right != null) {
            if (!process(node.right, node.val, max)) {
                return false;
            }
        }
        return true;
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

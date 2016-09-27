package $110;

public class BalancedBinaryTree {
	public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(getHeight1(root.left) - getHeight1(root.right)) > 1) {
            return false;
        }
        return isBalanced1(root.left) && isBalanced1(root.right);
    }
    
    int getHeight1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight1(node.left), getHeight1(node.right));
    }
    
    public boolean isBalanced2(TreeNode root) {
        return getHeight2(root) != -1;
    }
    
    int getHeight2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight2(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight2(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
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

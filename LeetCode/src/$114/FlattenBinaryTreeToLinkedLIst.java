package $114;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedLIst {
	public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            if (root.right != null) {
                stack.push(root.right);
                root.right = null;
            }
            if (root.left != null) {
                root.right = root.left;
                root.left = null;
            } else {
                if (!stack.isEmpty()) {
                    root.right = stack.pop();
                }
            }
            root = root.right;
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
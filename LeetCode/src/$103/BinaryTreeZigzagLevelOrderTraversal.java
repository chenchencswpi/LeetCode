package $103;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        boolean leftToRight = false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(root.val);
        res.add(new ArrayList<Integer>(numbers));
        numbers.clear();
        while (!stack.isEmpty()) {
            Stack<TreeNode> nextLevel = new Stack<>();
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (leftToRight) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                        numbers.add(node.left.val);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                        numbers.add(node.right.val);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                        numbers.add(node.right.val);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                        numbers.add(node.left.val);
                    }
                }
            }
            if (numbers.size() > 0) {
                res.add(new ArrayList<Integer>(numbers));
            }
            numbers.clear();
            leftToRight = (leftToRight == true)? false: true;
            stack = nextLevel;
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
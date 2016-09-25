package $349;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        process(root, res);
        return res;
    }
    
    int process(TreeNode node, List<List<Integer>> res) {
        if (node == null) {
            return -1;
        }
        int leftHeight = process(node.left, res);
        int rightHeight = process(node.right, res);
        int currHeight = 1 + Math.max(leftHeight, rightHeight);
        if (currHeight >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(currHeight).add(node.val);
        return currHeight;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int val) {
		this.val = val;
	}
}
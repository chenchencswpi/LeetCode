package $107;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        process(root, list, 0);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            res.add(list.get(i));
        }
        return res;
    }
    
    void process(TreeNode node, List<List<Integer>> list, int depth) {
        if (node == null) {
            return;
        }
        if (depth >= list.size()) {
            list.add(new ArrayList<Integer>());
        }
        List<Integer> curr = list.get(depth);
        curr.add(node.val);
        process(node.left, list, depth + 1);
        process(node.right, list, depth + 1);
    }
}

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int x) {
		val = x;
	}
}
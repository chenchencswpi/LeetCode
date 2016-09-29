package $257;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null) {
            return res;
        }
        process(res, "", root);
        return res;
    }
    
    //in this method, we assume the TreeNode is always valid (not null)
    void process(List<String> res, String prefix, TreeNode node) {
        prefix += "->" + node.val;
        if (node.left == null && node.right == null) {
            res.add(prefix.substring(2));
        }
        if (node.left != null) {
            process(res, prefix, node.left);
        }
        if (node.right != null) {
            process(res, prefix, node.right);
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
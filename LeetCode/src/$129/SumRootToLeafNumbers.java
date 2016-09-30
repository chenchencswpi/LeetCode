package $129;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<String> res = new ArrayList<>();
        process(res, "", root);
        int sum = 0;
        for (String s: res) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
    
    void process(List<String> res, String prefix, TreeNode node) {
        prefix += node.val;
        if (node.left == null && node.right == null) {
            res.add(prefix);
            return;
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
	TreeNode(int x) {
		val = x;
	}
}
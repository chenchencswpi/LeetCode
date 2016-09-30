package $113;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        process(res, new ArrayList<Integer>(), root, sum);
        return res;
    }
    
    //in this method, the node is always valid
    void process(List<List<Integer>> res, List<Integer> list, TreeNode node, int sum) {
        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                list.add(node.val);
                res.add(list);
            }
            return;
        }
        list.add(node.val);
        if (node.left != null) {
            process(res, new ArrayList<Integer>(list), node.left, sum - node.val);
        }
        if (node.right != null) {
            process(res, new ArrayList<Integer>(list), node.right, sum - node.val);
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
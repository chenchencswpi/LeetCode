package $337;

public class HouseRobberIII {
	public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    
    int[] dfs(TreeNode node) {
        int[] res = new int[2];
        if (node == null) {
            return res;
        }
        int[] left = dfs(node.left), right = dfs(node.right);
        res[0] = node.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
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
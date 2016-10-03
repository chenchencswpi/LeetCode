package $106;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return constructNode(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    TreeNode constructNode(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (postLeft > postRight) {
            return null;
        }
        int rootValue = postorder[postRight];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = findIndex(inorder, rootValue);
        root.left = constructNode(inorder, inLeft, rootIndex - 1, postorder, postLeft, postLeft + rootIndex - inLeft - 1);
        root.right = constructNode(inorder, rootIndex + 1, inRight, postorder, postRight - (inRight - rootIndex), postRight - 1);
        return root;
    }
    
    int findIndex(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
}

class TreeNode {
	int val;
	TreeNode left, right;
	TreeNode(int x) {
		val = x;
	}
}
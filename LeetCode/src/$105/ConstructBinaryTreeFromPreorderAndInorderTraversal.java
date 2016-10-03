package $105;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return constructNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    TreeNode constructNode(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = findIndex(inorder, rootValue);
        root.left = constructNode(preorder, preLeft + 1, preLeft + rootIndex - inLeft, inorder, inLeft, rootIndex - 1);
        root.right = constructNode(preorder, preRight - (inRight - rootIndex) + 1, preRight, inorder, rootIndex + 1, inRight);
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
	TreeNode (int x) {
		val = x;
	}
}
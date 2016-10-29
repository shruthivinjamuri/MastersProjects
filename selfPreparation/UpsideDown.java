package selfPreparation;

public class UpsideDown {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		left.left = new TreeNode(4);
		left.right = new TreeNode(5);
		root.inOrder(root);
		root = up(root);
		System.out.println();
		root.inOrder(root);

	}
	
	public static TreeNode up(TreeNode root) {
		if(root == null)
			return null;
		if(root.left == null && root.right == null)
			return root;
		TreeNode nRoot = up(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right=null;
		
		return nRoot;
		
	}

}

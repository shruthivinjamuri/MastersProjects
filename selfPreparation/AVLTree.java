package selfPreparation;

public class AVLTree {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);
		root = insert(root, 12);
		root = insert(root, 2);
		root = insert(root, 4);

		root = insert(root, 1);

		root = insert(root, 3);

		root = insert(root, 7);
		root = insert(root, 8);
		inOrder(root);
		root = delete(root, 5);
		System.out.println();
		inOrder(root);
	}

	public static TreeNode insert(TreeNode root, int key) {
		if (root == null)
			return new TreeNode(key);
		if (key < root.val)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);

		root.height = Math.max(height(root.left), height(root.right)) + 1;
		int bal = getBalance(root);

		// left let case
		if (bal > 1 && key < root.left.val)
			return rightRotate(root);

		// right right case
		if (bal < -1 && key > root.right.val)
			return leftRotate(root);

		// left right case
		if (bal > 1 && key > root.left.val) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		// right left case
		if (bal < -1 && key < root.right.val) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	public static void inOrder(TreeNode root) {
		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	private static int height(TreeNode root) {
		if (root == null)
			return 0;
		return root.height;
	}

	private static int getBalance(TreeNode root) {
		if (root == null)
			return 0;
		return height(root.left) - height(root.right);

	}

	private static TreeNode leftRotate(TreeNode root) {
		if (root == null)
			return root;
		TreeNode x = root.right;
		TreeNode T = x.left;

		// transform
		x.left = root;
		root.right = T;

		// update height
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		

		return x;
	}

	private static TreeNode rightRotate(TreeNode root) {
		if (root == null)
			return root;

		TreeNode x = root.left;
		TreeNode T = x.right;

		// transform
		x.right = root;
		root.left = T;

		// update height
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		x.height = Math.max(height(x.left), height(x.right)) + 1;
		

		return x;
	}

	public static TreeNode delete(TreeNode root, int key) {
		if (root == null)
			return null;
		if (root.val > key)
			root.left = delete(root.left, key);
		else if (root.val < key)
			root.right = delete(root.right, key);
		else {// equal case
			if (root.left == null && root.right == null)
				return null;
			if (root.left == null)
				return root.right;
			if (root.right == null)
				return root.left;
			int repKey = getLeftLargest(root.left);
			root.val = repKey;
			root.left = delete(root.left, repKey);
		}

		if (root == null)
			return root;

		root.height = Math.max(height(root.left), height(root.right)) + 1;

		int bal = getBalance(root);
		// left left case
		if (bal > 1 && getBalance(root.left) >= 0) {
			return rightRotate(root);
		}
		// right right case
		if (bal < -1 && getBalance(root.right) <= 0)
			return leftRotate(root);

		// left right case
		if (bal > 1 && getBalance(root.left) < 0) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}
		// right left case
		if (bal < -1 && getBalance(root.right) > 0) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	private static int getLeftLargest(TreeNode root) {
		TreeNode temp = root;
		while (temp.right != null)
			temp = temp.right;
		return temp.val;
	}

}

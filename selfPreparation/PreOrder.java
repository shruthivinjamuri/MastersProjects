package selfPreparation;

public class PreOrder {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		TreeNode left = new TreeNode(3);
		left.parent = root;
		TreeNode right = new TreeNode(8);
		right.parent = root;
		
		root.left = left;
		root.right = right;
		
		TreeNode left1 = new TreeNode(7);
		left1.parent = left;
		TreeNode left2= new TreeNode(9);
		left2.parent = left1;
		TreeNode left3 = new TreeNode(18);
		left3.parent = left;
		TreeNode left4 = new TreeNode(1);
		TreeNode left5 = new TreeNode(2);
		left4.parent = left3;
		left5.parent = left3;
		left.left = left1;
		left.right = left3;
		left1.left = left2;
		left3.left = left4;
		left3.right = left5;
		
		TreeNode right1 = new TreeNode(11);
		right1.parent = right;
		TreeNode right2 = new TreeNode(16);
		right2.parent = right1;
		TreeNode right3 = new TreeNode(17);
		right3.parent = right1;
		right.right = right1;
		right1.left = right2;
		right1.right = right3;
		System.out.println(preOrderAfter(left2));

	}
	
	public static int preOrderBefore(TreeNode root) {
		if(root == null || root.parent == null)
			return -1;
		if(root == root.parent.left) 
			return root.parent.val;
		else {
			return find(root.parent);
		}
			
	}

	private static int find(TreeNode root) {
		if(root.left == null)
			return root.val;
		TreeNode temp = root.left;
		while(temp.right == null) {
			if(temp.left == null)
				return temp.val;
			else
				temp = temp.left;
		}
		temp = temp.right;
		while(temp != null){
			if(temp.left == null && temp.right == null)
				return temp.val;
			else if(temp.right != null)
				temp = temp.right;
			else
				temp = temp.left;
		}
		return -1;
	}

	public static int preOrderAfter(TreeNode root) {
		if(root == null)
			return -1;
		if(root.left == null && root.right == null){
			TreeNode temp = root;
			while(temp != null){
				if(temp.parent == null)
						return -1;
				if(temp == temp.parent.left) {
					if(temp.parent.right != null)
						return temp.parent.right.val;
					else
						temp = temp.parent;
				}
				else {
					temp = temp.parent;
				}
			}
			return -1;
		}
		else if(root.left != null)
			return root.left.val;
		else
			return root.right.val;
	}
	
}

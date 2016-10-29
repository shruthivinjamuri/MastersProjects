package selfPreparation;

public class PopulateTreeSizes {

	public static void main(String[] args) {
		TreeNodeWSize root = new TreeNodeWSize(50);
		TreeNodeWSize root1 = new TreeNodeWSize(25);
		TreeNodeWSize root2 = new TreeNodeWSize(95);
		root.left = root1;
		root.right = root2;
		root2.left = new TreeNodeWSize(89);
		root2.right = new TreeNodeWSize(99);
		root1.left = new TreeNodeWSize(10);
		root1.right = new TreeNodeWSize(35);
		root1.right.right = new TreeNodeWSize(40);
		root1.left.left = new TreeNodeWSize(5);
		populate(root);
		print(root);
		root = insert(root, 101);
		root = insert(root,1);
		//System.out.println();
		print(root);
		root=delete(root, 50);
		//System.out.println();
		print(root);
		//System.out.println(kSearchElement(root, 11, 0));
	}
	
	public static int populate(TreeNodeWSize root) {
		if(root == null)
			return 0;
		int left = populate(root.left) ;
		int right = populate(root.right);
		root.size = left + right+1;
		return root.size;
	}
	
	public static void print(TreeNodeWSize root) {
		if(root == null)
			return;
		print(root.left);
		System.out.println("Value: "+root.val+" Size: "+root.size+" ");
		print(root.right);
	}
	
	public static TreeNodeWSize insert(TreeNodeWSize root, int val){
		if(root == null)
			return new TreeNodeWSize(val);
		if(root.val < val) {
			root.right = insert(root.right,val);
			root.size++;
			return root;
		}
		else {
			root.left= insert(root.left,val);
			root.size++;
			return root;
		}
	}
	private static int getLeftLargest(TreeNodeWSize root) {
		TreeNodeWSize temp = root;
		while(temp.right != null)
			temp = temp.right;
		return temp.val;
	}
	
	public static TreeNodeWSize delete(TreeNodeWSize root, int val) {
		if(root ==  null)
			return null;
		if(root.val < val) {
			if(root.right != null) {
				int prev = root.right.size;
				root.right = delete(root.right, val);
				if(root.right == null || prev != root.right.size) root.size--;
			}
			return root;
		}
		else if(root.val > val) {
			if(root.left!=null) {
				int prev = root.left.size;
				root.left = delete(root.left, val);
				if(root.left == null || prev != root.left.size) root.size--;
			}
			return root;
		}
		else {
			if(root.left == null && root.right == null)
				return null;
			if(root.left == null)
				return root.right;
			if(root.right == null)
				return root.left;
			else {
				int repValue = getLeftLargest(root.left);
				root.val = repValue;
				root.left = delete(root.left, repValue);
				root.size--;
				return root;
			}	
		}
	}
	
	public static int kSearchElement(TreeNodeWSize root, int k, int pk) {
		if (root == null)
			return -1;
		if (root.left != null) { // 2 in the below lines is: 1 for root and another one for left child
			if (k == root.left.size + 2 + pk)
				return root.val;
			else if (k < pk + root.left.size + 2)
				return kSearchElement(root.left, k, pk);
			else
				return kSearchElement(root.right, k, pk + root.left.size + 2);
		} else { // as there is not left child, so only 1
			if (k == pk + 1)
				return root.val;
			else if (k < pk + 1)
				return kSearchElement(root.left, k, pk);
			else
				return kSearchElement(root.right, k, pk + 1);
		}
	}

}

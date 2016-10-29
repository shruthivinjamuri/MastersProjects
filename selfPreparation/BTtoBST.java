package selfPreparation;

public class BTtoBST {

	public static void main(String[] args) {
		TreeNode bt = new TreeNode(10);
		bt.left = new TreeNode(2);
		bt.right = new TreeNode(7);
		bt.left.left = new TreeNode(8);
		bt.left.right = new TreeNode(4);
		bt.inOrder(bt);
		System.out.println();
		bt = convert(bt,null);
		bt.inOrder(bt);

	}
	
	public static TreeNode insert(TreeNode bst, TreeNode bt) {
		if(bt == null) return bst;
		if(bst == null) {
			bt.left=null;
			bt.right = null;
			return bt;
		}
		//System.out.println(bt.val+ " "+bst.val);
		
		if(bt.val <= bst.val) {
		 bst.left=insert(bst.left,bt);
		}
		else
			bst.right=insert(bst.right,bt);
		
		return bst;
	}
	
	public static TreeNode convert(TreeNode bt, TreeNode bst){
		if(bt == null)
			return bst;
		bst = convert(bt.left,bst);
		bst = convert(bt.right,bst);
		return insert(bst,bt);
	}

}

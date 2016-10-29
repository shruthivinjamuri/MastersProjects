package selfPreparation;

public class TreeNode {
	int val;
	int depth;
	int height;
	double pos;
	int size;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	TreeNode next;
	boolean isRoman;
	
	public TreeNode(int value){
		val = value;
		left = null;
		right = null;
		parent = null;
		isRoman=false;
		next=null;
	}
	
	public double[] getCoordinates(){
		double [] coor = new double[2];
		coor[0] = pos;
		coor[1] = depth;
		return coor;
	}
	
	public void inOrder(TreeNode root){
		if(root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val+" ");
		inOrder(root.right);
	}
}

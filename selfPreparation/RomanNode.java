package selfPreparation;

import java.util.ArrayList;
import java.util.List;

public class RomanNode {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(5);
		TreeNode left = new TreeNode(6);
		TreeNode right = new TreeNode(7);
		root.left = left;
		root.right = right;
		TreeNode left1 = new TreeNode(1);
		TreeNode left2 = new TreeNode(12);
		left.left = left1;
		left.right = left2;
		TreeNode left3 = new TreeNode(12);
		TreeNode left4 = new TreeNode(19);
		left2.left = left3;
		left2.right = left4;
		TreeNode left5 = new TreeNode(11);
		TreeNode left6 = new TreeNode(16);
		left3.left = left5;
		left3.right = left6;
		left5.left = new TreeNode(119);
		left5.right = new TreeNode(120);
		List<TreeNode> lst = new ArrayList<TreeNode>();
		roman(root,lst);
		for(TreeNode node: lst)
			System.out.println(node.val+" ");
		
		
	}
	
	/*
	 * public class TreeNode {
	 * int val;
	 * int size; 		//stores the number of descendants including itself
	 * boolean isRoman; // is true when this node is roman and all its descendants are roman, 
	 * 					//false even when a grand grand child node of this node is not roman.
	 * TreeNode left;
	 * TreeNode right;
	 * }
	 */
	public static void roman(TreeNode root, List<TreeNode> lst){
		if(root == null)
			return;
		if(root.left == null && root.right == null){
			root.size = 1;
			root.isRoman = true;
			return;
		}
		int left = 0;
		int right = 0;
		boolean isLeftRoman = false;
		boolean isRightRoman = false;
		 
		if(root.left != null) {
			roman(root.left,lst);
			left = root.left.size;
			isLeftRoman = root.left.isRoman;
		}
		
		
		if(root.right != null) {
			roman(root.right,lst);
			right = root.right.size;
			isRightRoman = root.right.isRoman;
		}
		
		//if the current node is roman and all it's descendants are roman, update isRoman to true
		if(Math.abs(left-right) <= 5 && isLeftRoman && isRightRoman)
			root.isRoman = true;
		else
			root.isRoman = false;
		
		//update the current node's size
		root.size = left+right+1;
		
		//add the node to list which is not roman but all its descendants are roman
		if(Math.abs(left-right) > 5 && isLeftRoman && isRightRoman)
			lst.add(root); 
	}

}

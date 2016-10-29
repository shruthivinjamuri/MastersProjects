package selfPreparation;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixTree {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(5);
		root1.left = root2;
		root1.right = root3;
		root3.left = root4;
		root2.right = root5;
		int height=Height(root1);
		//traverse(root1);
		calculate(root1,0,height);
		//traverse(root1);
	}
	
	public static void inOrder(TreeNode root){
		if(root == null)
			return;
		inOrder(root.left);
		System.out.println(root.val+" x: "+root.getCoordinates()[0]+" y: "+root.getCoordinates()[1]);
		inOrder(root.right);
	}
	
	public static int Height(TreeNode root) {
		if(root == null)
			return -1;
		int height = 1+ Integer.max(Height(root.left), Height(root.right)); 
		return height;
	}	
	
	public static void traverse(TreeNode root) {
		if(root == null)
			return;
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		int size = 1;
		int pos = 0;
		//root.pos = pos;
		while(!que.isEmpty()){
			TreeNode temp = que.poll();
			System.out.print(temp.val+" x: "+temp.getCoordinates()[0]+" y: "+temp.getCoordinates()[1]+"  ");
			size--;
			if(temp.left != null) {
				//temp.left.pos = pos;
				pos++;
				que.offer(temp.left);
			}
			if(temp.right != null) {
				//temp.right.pos = pos;
				pos++;
				que.offer(temp.right);
			}
			if(size == 0){
				System.out.println();
				size = que.size();
				pos = 0;
			}
		}
	}
	
	public static void calculate(TreeNode root, double margin, int height){
		if(root == null)
			return;
		root.pos = margin+Math.pow(2,height)/2;
		root.depth = height;
		System.out.println(root.val+" x: "+root.pos +" y: "+root.depth);
		calculate(root.left,margin,height-1);
		calculate(root.right,root.pos,height-1);
	}

}

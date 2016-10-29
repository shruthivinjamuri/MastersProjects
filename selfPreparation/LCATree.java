package selfPreparation;

import java.util.ArrayList;

public class LCATree {

	public static void main(String[] args) {
		Directory root = new Directory(1000);
		ArrayList<Directory> child = new ArrayList<>();
		child.add(new Directory(500));
		child.add(new Directory(300));
		child.add(new Directory(445));
		root.children = child;
		Directory left = root.children.get(0);
		Directory right = root.children.get(1);
		left.children.add(new Directory(400));
		left.children.add(new Directory(1200));
		left.children.add(new Directory(2200));
		right.children.add(new Directory(800));
		right.children.get(0).children.add(new Directory(66));
		Directory third = right.children.get(0).children.get(0);
		right.children.add(new Directory(900));
		right.children.add(new Directory(1900));
		Directory answer = LCA(root, right, third);
		System.out.println(answer.val);
	}
	
	public static Directory LCA(Directory root, Directory v, Directory w){
		if(root == null)
			return null;
		if(root == v || root == w)
			return root;
		Directory first = null;
		Directory second = null;
		for (Directory node : root.children) {
			Directory temp = LCA(node,v,w);
			if(temp!=null){
				if(first == null)
					first = temp;
				else
				{
					second = temp;
					break;
				}
			}
		}
		
		if(first != null && second != null)
			return root;
		else
			return first;
	}

}

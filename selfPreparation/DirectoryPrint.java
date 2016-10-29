package selfPreparation;

import java.util.ArrayList;

public class DirectoryPrint {

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
		right.children.add(new Directory(900));
		right.children.add(new Directory(1900));
		
		print(root,0);
	}
	
	private static void Space(int val, int spaces){
		for(int i=0;i<spaces;i++){
			System.out.print(" ");
		}
		System.out.print(val);
		System.out.println();
		
	}
	
	public static void print(Directory root, int level){
		if(root == null)
			return;
		Space(root.val,level);
		for(int i=0;i<root.children.size();i++){
			if(root.children.get(i) != null)
				print(root.children.get(i), level+1);
		 }
	}

}

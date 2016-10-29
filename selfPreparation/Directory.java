package selfPreparation;

import java.util.ArrayList;

public class Directory {
	int val;
	ArrayList<Directory> children;
	public Directory(int value){
		val = value;
		children = new ArrayList<Directory>();
	}
}

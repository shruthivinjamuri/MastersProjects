package selfPreparation;

public class Point {
	int row;
	int col;
	
	public Point(int r, int c){
		this.row = r;
		this.col = c;
	}
	
	public String toString(){
		return "("+row + ", "+col+")";
	}

}

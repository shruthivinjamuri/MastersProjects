package selfPreparation;

public class Line {
	
	public double left;
	public double right;
	
	public Line(double l, double r){
		this.left = l;
		this.right = r;
	}
	
	public String toString(){
		return "["+left+", "+right+"]";
	}

}

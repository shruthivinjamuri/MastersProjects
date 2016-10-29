package selfPreparation;

import java.util.ArrayList;
import java.util.Arrays;

public class SetZeros {
	
	public static void main(String [] args){
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		ArrayList<Integer>  a1 = new ArrayList<Integer>();
		a1.add(1);a1.add(0);
		ArrayList<Integer>  a2 = new ArrayList<Integer>();
		a2.add(1);a2.add(1);
		a.add(a1);a.add(a2);
		setZeroes(a);
		System.out.println(a);
	}
	
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		if (a == null || a.size() == 0)
			return;

		int rows = a.size();
		int cols = a.get(0).size();
		boolean rowZeros = false;
		boolean colZeros = false;
		for (int row = 0; row < rows; row++) {
			if (a.get(row).get(0) == 0 && !rowZeros)
				colZeros = true;
		}

		for (int col = 0; col < cols; col++) {
			if (a.get(0).get(col) == 0 && !colZeros)				
				rowZeros = true;
		}

		for (int row = 1; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				if (a.get(row).get(col) == 0) {
					a.get(0).set(col, 0);
					a.get(row).set(0, 0);
				}
			}
		}

		for (int row = 1; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				if (a.get(row).get(0) == 0 || a.get(0).get(col) == 0) {
					a.get(row).set(col, 0);
				}
			}
		}

		if (colZeros) {
			for (int row = 0; row < rows; row++) {
				a.get(row).set(0, 0);
			}
		}

		if (rowZeros) {
			for (int col = 0; col < cols; col++) {
				a.get(0).set(col, 0);
			}
		}

	}
}

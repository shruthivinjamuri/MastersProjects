package selfPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnightState {
	
	private KnightState prev;
	private int row;
	private int col;
	private static final int rows = 8;
	private static final int cols = 8;
	
	public KnightState(KnightState prev, int row, int col) {
		this.prev = prev;
		this.row = row;
		this.col= col;
	}
	
	public List<KnightState> nextMoves() {
		List<KnightState> moves = new ArrayList<>();
		if(row+2 < rows) {
			if(col-1 >= 0)
				moves.add(new KnightState(this,row+2,col-1));
			if(col+1 < cols)
				moves.add(new KnightState(this,row+2,col+1));
		}
		if(row-2 >= 0) {
			if(col-1 >= 0)
				moves.add(new KnightState(this,row-2,col-1));
			if(col+1 < cols)
				moves.add(new KnightState(this,row-2,col+1));
		}
		if(col-2 >= 0) {
			if(row-1 >= 0)
				moves.add(new KnightState(this,row-1,col-2));
			if(row+1 < rows)
				moves.add(new KnightState(this,row-1,col-2));				
		}
		if(col+2 < cols) {
			if(row-1 >= 0)
				moves.add(new KnightState(this,row-1,col+2));
			if(row+1 < rows)
				moves.add(new KnightState(this,row-1,col+2));
		}
		return moves;
		
	}
	
	@Override
    public int hashCode() {
        return (31 * 31 * row) + (31 * col);
    }

    @Override
    public boolean equals(Object obj) {
       KnightState other = (KnightState)obj;
    	return other.getRow() == this.getRow() ? this.getCol() == other.getCol() : false;
    }

    @Override
    public String toString() {
        return "("+row+", "+col+")";
    }

	public KnightState getPrev() {
		return prev;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
}

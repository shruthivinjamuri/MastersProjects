package selfPreparation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KnightPaths {
	private static int dRow;
	private static int dCol;
	
	public static void main(String[] args) {
		dRow = 0;
		dCol = 3;
		explore(0,2);
	}
	
	public static void explore(int sRow, int sCol) {
		KnightState initialState = new KnightState(null,sRow,sCol);
		Set<KnightState> visitedStates = new HashSet<>();
		visitedStates.add(initialState);
		Queue<KnightState> pendingStates = new LinkedList<>();
		pendingStates.offer(initialState);
		
		
		while(!pendingStates.isEmpty()) {
			KnightState curState = pendingStates.poll();
			if(isGoalReached(curState)) {
				getPath(curState);
				return;
			}
			
			for(KnightState state : curState.nextMoves()) {
				if(visitedStates.add(state))
					pendingStates.offer(state);
			}
		}
		
		System.out.println("("+dRow+", "+dCol+") is not reachable by knight at ("+sRow+", "+sCol+")");
	}
	
	private static boolean isGoalReached(KnightState pos) {
		return dRow == pos.getRow() ? dCol == pos.getCol() : false;
	}
	
	private static void getPath(KnightState state){
		if(state != null) {
			getPath(state.getPrev());
			System.out.println(state.toString());
		}
	}
	
	

}

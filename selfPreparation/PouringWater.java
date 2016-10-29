package selfPreparation;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class PouringWater {

	public static int x = 11;
	public static int y = 7;
	public static int z = 4;
	public static int a = 2;
	public static void main(String[] args) {
		int[] initialContent = {0,y,z};
		int[] capacity = {x,y,z};
		WaterState initialState = new WaterState(null,initialContent, capacity);
		Set<WaterState> completedStates = new HashSet<WaterState>();
		Queue<WaterState> pendingStates = new ArrayDeque<>();
		pendingStates.offer(initialState);
		completedStates.add(initialState);
		
		while(!pendingStates.isEmpty()) {
			WaterState temp = pendingStates.poll();
			if(isGoalReached(temp)) {
				pathsToHere(temp);
				return;
			}
			
			for(WaterState state: temp.adjacentStates()) {
				if(completedStates.add(state))
					pendingStates.offer(state);
			}
		}
		
		System.out.println("There seems to be no solution for given values.");

	}
	
	private static void pathsToHere(WaterState state) {
		if (state != null) {
			pathsToHere(state.getPrev());
			System.out.println(state);
		}
	}

	private static boolean isGoalReached(WaterState state) {
		for(int amt: state.getContent()) {
			if(amt == a) {
				return true;
			}
		}
		return false;
	}

}

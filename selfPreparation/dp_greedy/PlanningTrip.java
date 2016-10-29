package selfPreparation.dp_greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *Planning a trip. You are going on a long trip. You start on the road at
mile post 0. Along the way there are n hotels, at mile posts a1, a2, . . . , an with
a1 < a2 < . . . < an, where each ai
is measured from the starting point. The only
places you are allowed to stop are at these hotels, but you can choose where you
want to stop. Your final destination is the hotel at an.
You’d ideally like to travel 200 miles a day, but this may not be possible because
of the spacing of the hotels. If you travel x miles during a day, the penalty for
that day is |200 − x|. Notice that there is a penalty when you travel less than 200
miles or when you travel more than 200 miles. You want to plan your trip so as
to minimize the total penalty – i.e., the sum of the daily penalties over all travel
days.
a. If you’re me, you’d consider the greedy method to solve the problem: On the
first day, choose the hotel at ai so that |200 − ai
| is as small as possible. On the
second day, choose the hotel at aj where aj > ai so that |200−(aj −ai)| is as small
as possible. Keep doing this until the hotel at an is reached. Unfortunately, this
algorithm does not work! Find an example that shows that this greedy algorithm
will not produce an optimal plan.
b. For j = 1, . . . n, define PENALTY(j) to be the largest penalty incurred by a
trip that considers only hotels 1, . . . , j. Design a dynamic programming algorithm
that solves PENALTY(n).
c. Finally, use the dynamic program to output the optimal plan – i.e. the plan
states where you should stop for each day
 */
public class PlanningTrip {

	public static void main(String[] args) {
		int a[] = {0,100,220,380,460,600,750};
		//int a[] = {0,180,330,440,630,820,950,1100,1300};
		//System.out.println("Greedy: "+greedy(a));
		List<Integer> stops = new ArrayList<Integer>();
 		System.out.println("Dp: "+dp(a,stops, 200));
		for(Integer stop: stops) {
			System.out.print(stop + " ");
		}
	}
	
	public static int greedy(int a[]){
		int cur=0;
		int oldPen = Integer.MAX_VALUE;
		int curPen =0;
		int penality=0;
		for (int i = 0; i < a.length; i++) {
			curPen = 200 + cur - a[i];
			if(curPen > 0){
				if(oldPen > curPen){
					oldPen = curPen; 
				}
				else {
					cur = a[i];
					penality += oldPen;
					oldPen = Integer.MAX_VALUE;
				}
			}
			else {
				if(oldPen > Math.abs(curPen)){
					 oldPen = Math.abs(curPen); 
					 cur =a[i];
				}
				else
					cur = a[i-1];
				
				penality += oldPen;
				oldPen = Integer.MAX_VALUE;
			}
		}
		
		return penality;
	}
	
	public static int dp(int a[], List<Integer> ans, int limit){
		int p[] = new int[a.length];
		HashMap<Integer, List<Integer>> stops = new HashMap<>();
		List<Integer> stop = new ArrayList<Integer>();
		stop.add(0);
		stops.put(0, stop);
		stop=null;
		p[0] = 0;
		for(int i=1; i< a.length;i++){
			int min = Integer.MAX_VALUE;
			for(int j = i-1;j >= 0; j--){
				if(min > p[j] + Math.abs(limit - (a[i]-a[j]))) {
				   min = p[j] + Math.abs(limit - (a[i]-a[j]));
				   stop = stops.get(a[j]);
				}
			}
			p[i] = min;
			//below three lines are to store the pit stop hotels
			List<Integer> minStop = new ArrayList<Integer>(stop);
			minStop.add(a[i]);
			stops.put(a[i],minStop);
		}
		ans.addAll(stops.get(a[a.length-1]));
		return p[a.length-1];
	}

}

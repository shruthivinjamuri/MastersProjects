package selfPreparation;

import java.util.Arrays;

public class MaxPeopleInRoom {

	public static void main(String[] args) {
		int start[] = {1, 2, 10, 5, 5};
		int end[] = {4, 5, 12, 9, 12};
		maxPeople(start, end);

	}
	
	public static void maxPeople(int start[], int end[]){
		if(start == null || end == null || start.length ==0 || end.length ==0){
			return;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		
		int guest=1;
		int max_guest = 1;
		int s =1; 
		int e =0;
		int time = start[0];
		while(s < start.length && e < end.length){
			if(start[s] <= end[e]){
				guest++; 
				//update max_guests here only.  
				if(guest > max_guest) {
					max_guest = guest;
					time = start[s];
				}
				s++;
			}
			else {
				guest--;
				e++;
			}
		}
		System.out.println(max_guest +" at: "+time);
	}

}

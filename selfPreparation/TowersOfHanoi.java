package selfPreparation;

public class TowersOfHanoi {

	public static void main(String[] args) {
		int n = 3; // three towers hanoii
		Tower towers[] = new Tower[n]; 
		for(int i=0; i<n;i++){
			towers[i] = new Tower();
		}
		
		//add disks to origin tower, here towers[0]
		for(int i=n-1;i>=0;i--){
			towers[0].add(i);
		}
		
		//algo -- disks, origin, buffer, destination
		moveDisks(n,towers[0],towers[1],towers[2]);
		while(!towers[2].isEmpty()) {
			System.out.print(towers[2].pop()+" ");
		}
	}

	private static void moveDisks(int n, Tower orgin, Tower buffer, Tower destination) {
		if(n <= 0) return;
		moveDisks(n-1,orgin, destination, buffer);
		orgin.moveTopTo(destination);
		moveDisks(n-1,buffer,orgin,destination);		
	}

}

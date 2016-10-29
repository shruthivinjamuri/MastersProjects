package selfPreparation;

import java.util.Scanner;

public class TakeInputFromConsole {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		//System.out.println("Enter integers:");
		int ip = scan.nextInt();
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		while(ip != 0){
			if(ip % 2  ==0){
				if(max < ip)
					max = ip;
			}
			else {
				if(min>ip)
					min=ip;
			}
			ip = scan.nextInt();
		}
		System.out.println("Max value: "+max+" & Min value: "+min);
		scan.close();
	}
}

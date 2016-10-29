package selfPreparation;

import java.util.Arrays;

public class EvalPokerHands {

	public static void main(String[] args) {
		int hand[] = {2,2,10,2,13};
		eval(hand);

	}
	/**
	 * A - 1, J - 11, Q - 12, K- 13
	 * @param hand
	 */
	public static void eval(int[] hand){
		int[] cards = new int[13];
		for(int h: hand){
			cards[h-1]++;
		}
		int highCard = 0;
		if(cards[0] > 1) highCard=1; //if 'A' is present high card is A only
		else{ //find out the high card from back of the cards array
			//just save the high card
			for(int i=cards.length-1;i>=0;i--){
				if(cards[i] != 0){
					highCard=i+1;
					break;
				}
			}
		}
		int lstIdx=cards.length-1;
		Arrays.sort(cards);
		if(cards[lstIdx] == 4) System.out.println("Four of a kind");
		else if(cards[lstIdx] == 3 && cards[lstIdx-1] == 2) System.out.println("Full house");
		else if(cards[lstIdx] == 3) System.out.println("Three of a kind");
		else if(cards[lstIdx] == 2 && cards[lstIdx-1] == 2) System.out.println("Two Pair");
		else if(cards[lstIdx] == 2) System.out.println("One pair");
		else System.out.println("The high card is: "+highCard);
	}

}

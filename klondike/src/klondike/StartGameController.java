package klondike;

import java.util.ArrayList;
import java.util.Stack;

public class StartGameController {

	public int sizeWaste() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Integer> sizeFoundations() {
		ArrayList<Integer> sizeFoundations = new ArrayList<Integer>();
		for(int i = 0; i < 4; i++){
			sizeFoundations.add(0);
		}					
		return sizeFoundations;
	}
	
	
	public int sizeDeck(){
		return 24;
	}

	public ArrayList<Integer> sizeCoveredCardsTableaus() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 7 ; i++){
			list.add(i+1);
		}		
		return list;
	}

	public ArrayList<Stack<Card>> uncoveredCardsStackTableaus() {		
		ArrayList<Stack<Card>> list = new ArrayList<Stack<Card>>();
		for (int i = 0; i < 7 ; i++){
			Stack<Card> stack = new Stack<Card>();
			Card card = new Card();
			card.turnOver();
			stack.add(card);
			list.add(stack);
		}		
		return list;
	}
	
	
}

package klondike;

import java.util.ArrayList;
import java.util.Stack;

public class StartGameController {
	
	private static final int numFoundations = 4;
	private static final int numTableaus = 7;
	private static final int initNumCardsInDeck = 52;
	
	private ArrayList<Stack<Card>> waste;
	private ArrayList<Stack<Card>> deck;

	public StartGameController(){
		FullDeck serving = new FullDeck();
		waste = new ArrayList<Stack<Card>>();
		waste.add(new Stack<Card>());
		deck = new ArrayList<Stack<Card>>();
		deck.add(new Stack<Card>());
		
		
		for (int i=0; i < initNumCardsInDeck; i++){		
			deck.add(new Stack<Card>());
			
			}
		
	}
	
	public int sizeWaste() {
		return waste.size();
	}

	
	public ArrayList<Integer> sizeFoundations() {
		ArrayList<Integer> sizeFoundations = new ArrayList<Integer>();
		for(int i = 0; i < numFoundations; i++){
			sizeFoundations.add(0);
		}					
		return sizeFoundations;
	}
	
	
	public int sizeDeck(){
		return deck.size();
	}

	public ArrayList<Integer> sizeCoveredCardsTableaus() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numTableaus ; i++){
			list.add(i+1);
		}		
		return list;
	}

	public ArrayList<Stack<Card>> uncoveredCardsStackTableaus() {		
		ArrayList<Stack<Card>> list = new ArrayList<Stack<Card>>();
		for (int i = 0; i < numTableaus ; i++){
			Stack<Card> stack = new Stack<Card>();
			Card card = new Card();
			card.turnOver();
			stack.add(card);
			list.add(stack);
		}		
		return list;
	}
	
	
}

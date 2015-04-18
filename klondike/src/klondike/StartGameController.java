package klondike;

import java.util.ArrayList;
import java.util.Stack;

public class StartGameController {
	
	private static final int numFoundations = 4;
	private static final int numTableaus = 7;
	private static final int initNumCardsInDeck = 52;
	
	private Stack<Card> waste;
	private Stack<Card> deck;
	private ArrayList<Stack<Card>> foundations;
	private ArrayList<Stack<Card>> tableaus;
	

	public StartGameController(){
		FullDeck serving = new FullDeck();
		waste = new Stack<Card>();
		deck = new Stack<Card>();
		foundations = new ArrayList<Stack<Card>>();
		tableaus = new ArrayList<Stack<Card>>();
		
		for (int i=0; i < numFoundations; i++){		
			foundations.add(new Stack<Card>());
			}
		
		for (int i=0; i < numTableaus; i++){		
			tableaus.add(new Stack<Card>());
			}
		
		for (int i=0; i < numTableaus; i++){		
			for (int j=0; j < numTableaus; j++){
				
				if (j==i){
					//poner carta boca arriba
					tableaus.get(i).add(extraerCarta(serving).turnOver());
				} else if (j>i){
					//poner carta boca abajo
					tableaus.get(i).add(extraerCarta(serving));
				}
				
			}
			
			}
		
		
	}
	
	private Card extraerCarta(FullDeck serving) {
		// TODO Auto-generated method stub
		return null;
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
			Card card = new Card("A",Suits.SPADES);
			card.turnOver();
			stack.add(card);
			list.add(stack);
		}		
		return list;
	}
	
	
}

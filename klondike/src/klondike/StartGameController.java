package klondike;

import java.util.ArrayList;
import java.util.Random;
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
			for (int j=i; j < numTableaus; j++){
				
				if (j==i){
					tableaus.get(j).add(extraerCarta(serving).turnOver());
				} else {
					tableaus.get(j).add(extraerCarta(serving));
					}
			}
			
		}
		
		for (int i=0; i < initNumCardsInDeck; i++){
			if (!serving.used[i]){
				deck.add(new Card(serving.face[i],serving.suit[i]));
			}
		}
		
	}
	
	private Card extraerCarta(FullDeck serving) {
		 Random rnd = new Random();
		 int randomNum;
		 do {
			 randomNum = rnd.nextInt(initNumCardsInDeck-1);
		 } while (serving.used[randomNum]);
		 
		 serving.used[randomNum] = true;
		return new Card(serving.face[randomNum],serving.suit[randomNum]);
	}

	
	public int sizeWaste() {
		return waste.size();
	}

	
	public ArrayList<Integer> sizeFoundations() {
		ArrayList<Integer> sizeFoundations = new ArrayList<Integer>();
		for (Stack<Card> foundation : foundations){
			sizeFoundations.add(foundation.size());
		}			
		return sizeFoundations;
	}
	
	
	public int sizeDeck(){
		return deck.size();
	}

	public ArrayList<Integer> sizeCoveredCardsTableaus() {
		ArrayList<Integer> sizetableaus = new ArrayList<Integer>();
		for (Stack<Card> tableau : tableaus){
			sizetableaus.add(tableau.size());
		}			
		return sizetableaus;
	}

	public ArrayList<Stack<Card>> uncoveredCardsStackTableaus() {		
		ArrayList<Stack<Card>> uncoveredCards = new ArrayList<Stack<Card>>();
		for (Stack<Card> tableau : tableaus){
			Stack<Card> uncoveredStack = new Stack<Card>();
			for (Card card : tableau){
				if (card.uncovered())
					uncoveredStack.add(card);
			}
			uncoveredCards.add(uncoveredStack);
		}
		return uncoveredCards;
	}
	
	public Game getGame(){
		return new Game(foundations,tableaus,deck,waste);
	}
	
}

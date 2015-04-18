package klondike;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
	
	private Stack<Card> waste;
	private Stack<Card> deck;
	private ArrayList<Stack<Card>> foundations;
	private ArrayList<Stack<Card>> tableaus;

	public Game(ArrayList<Stack<Card>> foundations,
			ArrayList<Stack<Card>> tableaus, Stack<Card> deck, Stack<Card> waste) {		
		this.setDeck(deck);
		this.setWaste(waste);
		this.setFoundations(foundations);
		this.setTableaus(tableaus);
	}

	public Stack<Card> getWaste() {
		return waste;
	}

	public void setWaste(Stack<Card> waste) {
		this.waste = waste;
	}

	public Stack<Card> getDeck() {
		return deck;
	}

	public void setDeck(Stack<Card> deck) {
		this.deck = deck;
	}

	public ArrayList<Stack<Card>> getFoundations() {
		return foundations;
	}

	public void setFoundations(ArrayList<Stack<Card>> foundations) {
		this.foundations = foundations;
	}

	public ArrayList<Stack<Card>> getTableaus() {
		return tableaus;
	}

	public void setTableaus(ArrayList<Stack<Card>> tableaus) {
		this.tableaus = tableaus;
	}

}

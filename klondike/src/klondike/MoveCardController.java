package klondike;

import java.util.ArrayList;
import java.util.Stack;

import klondike.Card;

public class MoveCardController {
	
	private Game game;
	
	
	public MoveCardController(Game game){
		this.game = game;
	}
	
	
	public void fromDeckToWaste() throws Exception{
		if (game.getDeck().size() == 0){
			throw new RuntimeException ( "Forbidden" ) ;
		} else{
			Stack<Card> deck = game.getDeck();
			Card card = deck.pop();
			card.turnOver();
			Stack<Card> stack = game.getWaste();
			stack.push(card);
			game.setWaste(stack);
			game.setDeck(deck);
		}
				
	}

	public void fromWasteToFoundation(Integer index) throws Exception{
		Card card = game.getWaste().peek();
		if (card.getFace()==1 ){
			if (game.getFoundations().get(index).size() != 0){
				throw new RuntimeException ( "Forbidden" ) ;
			} else{				
				makeMoveWasteToFoundation(index);
			}
			
		} else {
			if (game.getFoundations().get(index).size() ==0)
				throw new RuntimeException ( "Forbidden" ) ;
			else
				if ( card.getFace()-game.getFoundations().get(index).peek().getFace() != 1){
					throw new RuntimeException ( "Forbidden" ) ;
				}else{
					if ( card.getSuit() == game.getFoundations().get(index).peek().getSuit())
						makeMoveWasteToFoundation(index);
					}
				}
	}
			

	private void makeMoveWasteToFoundation(Integer index) {
		Stack<Card> waste = game.getWaste();
		Card card = waste.pop();
		Stack<Card> foundation = game.getFoundations().get(index);
		ArrayList<Stack<Card>> foundations = game.getFoundations();
		foundation.push(card);
		foundations.set(index, foundation);
		game.setFoundations(foundations);
		game.setWaste(waste);
	}


	public void fromWasteToTableau(int index) throws Exception{
		Card card = game.getWaste().peek();
		ArrayList<Stack<Card>> tableaus = game.getTableaus();
		Stack<Card> tableau = tableaus.get(index);
		if (tableau.size() == 0 ){
			if (card.getFace() == 13){
				makeMoveWasteToTableau(index);
			} else{
				throw new RuntimeException ( "Forbidden" ) ;
			}
		} else if(tableau.peek().getFace() - card.getFace() == 1 && checkColour(tableau.peek(),card)){
			makeMoveWasteToTableau(index);
		} else {
			throw new RuntimeException ( "Forbidden" ) ;
		}
		
	}

	
	private boolean checkColour(Card peek, Card card) {
		return peek.getColour() != card.getColour();			
	}


	private void makeMoveWasteToTableau(int index) {
		Stack<Card> waste = game.getWaste();
		Card card = waste.pop();
		ArrayList<Stack<Card>> tableaus = game.getTableaus();
		Stack<Card> tableau = game.getFoundations().get(index);		
		tableau.push(card);
		tableaus.set(index, tableau);
		game.setFoundations(tableaus);
		game.setWaste(waste);		
	}


	public Card getFirstCardDeck() {
		if (game.getDeck().size() > 0)
			return game.getDeck().peek();
		else
			return null;
	}

	public Card getFirstCardWaste() {
		if (game.getWaste().size() > 0)
			return game.getWaste().peek();
		else
			return null;
	}
	
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}


	
}


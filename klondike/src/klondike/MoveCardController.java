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
			
		
		
		/*ArrayList<Stack<Card>> tableaus = game.getTableaus();
		Stack<Card> tableau = new Stack<Card>();
		if (index==0){
			tableau.push(new Card(13,Suits.SPADES));
			tableaus.set(0, tableau);
			game.setWaste(new Stack<Card>());
			game.setTableaus(tableaus);
		} else if (index == 1){
			throw new RuntimeException ( "Forbidden" ) ;
		} else if (index == 2){
			throw new RuntimeException ( "Forbidden" ) ;
		} else if (index == 3){
			throw new RuntimeException ( "Forbidden" ) ;
		} else if (index == 4){
			tableaus = game.getTableaus();
			tableau = new Stack<Card>();
			tableau.push(new Card(9,Suits.SPADES));
			tableaus.set(4, tableau);
			game.setWaste(new Stack<Card>());
			game.setTableaus(tableaus);
		}*/
		
		
	}

	
	private boolean checkColour(Card peek, Card card) {
		// TODO Auto-generated method stub
		return false;
	}


	private void makeMoveWasteToTableau(int index) {
		// TODO Auto-generated method stub
		
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


package klondike;

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
			Card card = game.getDeck().pop();
			card.turnOver();
			Stack<Card> stack = game.getWaste();
			stack.push(card);
			game.setWaste(stack);
		}
				
	}

	public void fromWasteToFoundation(){
		
	}
	
	
	public void fromWasteToTableau(){
		
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


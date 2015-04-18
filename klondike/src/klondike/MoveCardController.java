package klondike;

import java.util.Random;

import klondike.Card;

public class MoveCardController {
	
	private Game game;
	
	public MoveCardController(Game game){
		this.game = game;
	}
	
	public void fromDeckToWaste(){
		 
	}

	public void fromWasteToFoundation(){
		
	}
	
	
	public void fromWasteToTableau(){
		
	}

	public Card getFirstCardDeck() {
		Random rnd = new Random();
		int randomNum;
		randomNum = (rnd.nextInt(12))+1;
		return new Card(randomNum,Suits.SPADES);
	}

	public Card getFirstCardWaste() {
		Random rnd = new Random();
		int randomNum;
		randomNum = (rnd.nextInt(12))+1;
		return new Card(randomNum,Suits.CLUBS);
	}
}


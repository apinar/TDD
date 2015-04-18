package test;

import static org.junit.Assert.*;

import java.util.Stack;

import klondike.Card;
import klondike.Game;
import klondike.MoveCardController;
import klondike.StartGameController;
import klondike.Suits;

import org.junit.Before;
import org.junit.Test;

public class MoveCardControllerTest {
	
	private StartGameController startGameController;
	private MoveCardController moveCardController;

	@Before
	public void before(){
		startGameController = new StartGameController();
		moveCardController = new MoveCardController(startGameController.getGame());
	}
	
	

	@Test
	public void fromDeckToWasteTest() {
		
		Game game = moveCardController.getGame();
		Stack<Card> stack = game.getWaste();
		stack.add(new Card(13,Suits.DIAMONDS));
		game.setWaste(stack);
		moveCardController.setGame(game);
		
		Card firstWaste = moveCardController.getFirstCardWaste();
		Card firstDeck = moveCardController.getFirstCardDeck();
		moveCardController.fromDeckToWaste();
		Card newWaste = moveCardController.getFirstCardWaste();
		Card newDeck = moveCardController.getFirstCardDeck();

		assertFalse((firstWaste.getFace() == newWaste.getFace()) && (firstWaste.getSuit() == newWaste.getSuit()));
		assertFalse((firstDeck.getFace() == newDeck.getFace()) && (firstDeck.getSuit() == newDeck.getSuit()));
		
		assertTrue((firstDeck.getFace() == newWaste.getFace()) && (firstDeck.getSuit() == newWaste.getSuit()));
		assertTrue(newWaste.uncovered());
		
		assertFalse((newDeck.getFace() == newWaste.getFace()) && (newDeck.getSuit() == newWaste.getSuit()));
		
	}
	
	@Test
	public void fromWasteToFoundationTest(){
		
	}
	
	@Test
	public void fromWasteToTableauTest(){
		
	}
	
}

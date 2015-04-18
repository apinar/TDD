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
	public void fromDeckToWasteTest() throws Exception {
		
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
	public void fromDeckToEmptyWasteTest() throws Exception {		
		startGameController = new StartGameController();
		moveCardController = new MoveCardController(startGameController.getGame());
		
		Card firstWaste = moveCardController.getFirstCardWaste();
		Card firstDeck = moveCardController.getFirstCardDeck();
		moveCardController.fromDeckToWaste();
		Card newWaste = moveCardController.getFirstCardWaste();
		Card newDeck = moveCardController.getFirstCardDeck();	
		
		assertNull(firstWaste);
		assertTrue((firstDeck.getFace() == newWaste.getFace()) && (firstDeck.getSuit() == newWaste.getSuit()));
		assertFalse((newDeck.getFace() == newWaste.getFace()) && (newDeck.getSuit() == newWaste.getSuit()));		
	}
	
	
	@Test(expected=Exception.class)
	public void fromEmptyDeckToWasteTest() throws Exception {		
		Game game = moveCardController.getGame();
		Stack<Card> stack = game.getWaste();
		stack.add(new Card(13,Suits.DIAMONDS));
		game.setWaste(stack);
		Stack<Card> empty = new Stack<Card>();
		game.setDeck(empty);
		moveCardController.setGame(game);
		
		Card firstDeck = moveCardController.getFirstCardDeck();
		moveCardController.fromDeckToWaste();
		
		assertNull(firstDeck);
		
	}
		
	
	@Test
	public void fromWasteFirstToFoundationTest(){
		
		
	}
	
	
	@Test
	public void fromWasteNotFirstToFoundationTest(){
		
		
	}
	
	
	@Test
	public void fromWasteToTableauTest(){
		
	}
	
}

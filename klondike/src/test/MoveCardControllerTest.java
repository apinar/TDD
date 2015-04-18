package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
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
	public void fromWasteAceToFoundationTest() throws Exception{
		Game game = moveCardController.getGame();
		Stack<Card> stack = game.getWaste();
		stack.add(new Card(1,Suits.DIAMONDS));
		game.setWaste(stack);	
		moveCardController.fromWasteToFoundation(0);
		//movemos un as a un palo vacío
		assertEquals(Integer.valueOf(1) , moveCardController.getGame().getFoundations().get(0).peek().getFace());
		
		ArrayList<Stack<Card>> foundations = game.getFoundations();
		Stack<Card> foundation = foundations.get(1);
		foundation.add(new Card(6,Suits.CLUBS));
		foundations.set(1, foundation);
		game.setFoundations(foundations);
		stack = game.getWaste();
		stack.add(new Card(1,Suits.DIAMONDS));
		game.setWaste(stack);	
				
		try {
			moveCardController.fromWasteToFoundation(1);
			//movemos un as a un palo que no le corresponde
		    fail("Movimiento no permitido");
		  } catch (Exception e) {
			  assertEquals(e.getMessage(), "Forbidden");
		  }	
	}
	
	
	@Test
	public void fromWasteNotAceToFoundationTest() throws Exception{
		Game game = moveCardController.getGame();
		Stack<Card> stack = game.getWaste();
		stack.add(new Card(5,Suits.DIAMONDS));
		game.setWaste(stack);
		//moveCardController.fromWasteToFoundation(1);
		
		//Movemos a un palo correcto
		ArrayList<Stack<Card>> foundations = game.getFoundations();
		Stack<Card> foundation = foundations.get(1);
		foundation.push(new Card(4,Suits.DIAMONDS));
		foundations.set(1, foundation);
		game.setFoundations(foundations);
		moveCardController.fromWasteToFoundation(1);
		assertTrue(moveCardController.getGame().getFoundations().get(1).peek().getFace()==5);
		assertTrue(moveCardController.getGame().getFoundations().get(1).peek().getSuit()==Suits.DIAMONDS);
			
		
		//Movemos a un palo con un nº no consecutivo
		stack = game.getWaste();
		stack.add(new Card(6,Suits.DIAMONDS));
		game.setWaste(stack);
		foundations = game.getFoundations();
		foundation = foundations.get(2);
		foundation.add(new Card(4,Suits.DIAMONDS));
		foundations.set(2, foundation);
		game.setFoundations(foundations);
		try {
			moveCardController.fromWasteToFoundation(2);
			 fail("Movimiento no permitido");
		  } catch (Exception e) {
			  assertEquals(e.getMessage(), "Forbidden");
		  }	
		
		
		//Movemos a un palo que no corresponde con el palo de la carta a mover
		stack = game.getWaste();
		stack.add(new Card(7,Suits.DIAMONDS));
		game.setWaste(stack);
		foundations = game.getFoundations();
		foundation = foundations.get(3);
		foundation.add(new Card(8,Suits.HEARTS));
		foundations.set(3, foundation);
		game.setFoundations(foundations);
		try {
			moveCardController.fromWasteToFoundation(3);
			 fail("Movimiento no permitido");
		  } catch (Exception e) {
			  assertEquals(e.getMessage(), "Forbidden");
		  }					
	}
	
	
	@Test
	public void fromWasteToTableauTest(){
		
	}
	
}

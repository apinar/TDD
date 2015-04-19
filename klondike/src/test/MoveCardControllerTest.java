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
	public void fromWasteToTableauTest() throws Exception{
		Game game = moveCardController.getGame();
		
		// Movemos un rey a un tableau vacío - movimiento correcto
		Stack<Card> stack = game.getWaste();
		stack.add(new Card(13,Suits.SPADES));
		game.setWaste(stack);
		ArrayList<Stack<Card>> tableaus = moveCardController.getGame().getTableaus();
		Stack<Card> tableau = new Stack<Card>();
		tableaus.set(0, tableau);
		game.setTableaus(tableaus);
		moveCardController.setGame(game);
		moveCardController.fromWasteToTableau(0);
		assertTrue(moveCardController.getGame().getTableaus().get(0).peek().getFace() == 13);
		assertTrue(moveCardController.getGame().getTableaus().get(0).peek().getSuit() == Suits.SPADES);
		assertTrue(moveCardController.getGame().getWaste().size()==0);
		
		// Movemos un rey a un tableau no vacío - movimiento erróneo
		stack = game.getWaste();
		stack.add(new Card(13,Suits.SPADES));
		game.setWaste(stack);
		tableaus = moveCardController.getGame().getTableaus();
		tableau = tableaus.get(1);
		tableau.push(new Card(5,Suits.CLUBS));
		tableaus.set(1, tableau);
		game.setTableaus(tableaus);
		moveCardController.setGame(game);
		try {
			moveCardController.fromWasteToTableau(1);
			 fail("Movimiento no permitido");
		  } catch (Exception e) {
			  assertEquals(e.getMessage(), "Forbidden");
		  }					
		
		//Movemos una carta cualquiera a un tableau vacío - movimiento erróneo
		stack = game.getWaste();
		stack.add(new Card(7,Suits.HEARTS));
		game.setWaste(stack);
		tableaus = moveCardController.getGame().getTableaus();
		tableau = new Stack<Card>();
		tableaus.set(2, tableau);
		game.setTableaus(tableaus);
		moveCardController.setGame(game);
		try {
			moveCardController.fromWasteToTableau(2);
			 fail("Movimiento no permitido");
		  } catch (Exception e) {
			  assertEquals(e.getMessage(), "Forbidden");
		  }					
		
		// Movemos una carta cualquiera a un tableau incorrecto - movimiento erróneo
		stack = game.getWaste();
		stack.add(new Card(7,Suits.SPADES));
		game.setWaste(stack);
		tableaus = moveCardController.getGame().getTableaus();
		tableau = tableaus.get(3);
		tableau.push(new Card(8,Suits.CLUBS));
		tableaus.set(3, tableau);
		game.setTableaus(tableaus);
		moveCardController.setGame(game);
		try {
			moveCardController.fromWasteToTableau(3);
			 fail("Movimiento no permitido");
		  } catch (Exception e) {
			  assertEquals(e.getMessage(), "Forbidden");
		  }					
		
		
		// Movemos una carta cualquiera a un tableau correcto - movimiento correcto
		stack = game.getWaste();
		stack.add(new Card(9,Suits.SPADES));
		game.setWaste(stack);
		tableaus = moveCardController.getGame().getTableaus();
		tableau = tableaus.get(4);
		tableau.push(new Card(10,Suits.DIAMONDS));
		tableaus.set(4, tableau);
		game.setTableaus(tableaus);
		moveCardController.setGame(game);
		int sizeWasteBeforeMove = moveCardController.getGame().getWaste().size();
		moveCardController.fromWasteToTableau(4);
		
		assertTrue(moveCardController.getGame().getTableaus().get(4).peek().getFace() == 9);
		assertTrue(moveCardController.getGame().getTableaus().get(4).peek().getSuit() == Suits.SPADES);
		assertTrue(moveCardController.getGame().getWaste().size()+1 == sizeWasteBeforeMove);
		
		
	}
	
}

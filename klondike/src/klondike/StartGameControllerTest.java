package klondike;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class StartGameControllerTest {
	
	private StartGameController startGameController;
	

	@Before
	public void before(){
		startGameController = new StartGameController();
	}
	
	
	@Test
	public void sizeWasteTest() {
		
		assertEquals(0,startGameController.sizeWaste());
		
	}

	@Test
	public void sizeFoundationsTest() {
		
		ArrayList<Integer> sizeFoundations = startGameController.sizeFoundations();
		assertEquals(4,sizeFoundations.size());
		
		for(int sizeFoundation : startGameController.sizeFoundations()){
			assertEquals(0,sizeFoundation);
		}
		
	}

	
	
	
}

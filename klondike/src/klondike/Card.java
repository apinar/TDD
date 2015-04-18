package klondike;

public class Card {
	boolean uncovered;
	
	public Card(){
		this.uncovered = false;
	}

	public boolean uncovered() {
		return uncovered;
	}
	
	public void turnOver(){
		uncovered = !uncovered;
	}
}

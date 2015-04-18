package klondike;

public class Card {
	private boolean uncovered;
	private String face; 
	private Suits suit;
	
	public Card(String face, Suits suit){
		this.uncovered = false;
		this.setFace(face);
		this.setSuit(suit);		
	}

	public boolean uncovered() {
		return uncovered;
	}
	
	public Card turnOver(){
		uncovered = !uncovered;
		return this;
	}

	public Suits getSuit() {
		return suit;
	}

	public void setSuit(Suits suit) {
		this.suit = suit;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}
}

package klondike;

public class Card {
	private boolean uncovered;
	private Integer face; 
	private Suits suit;
	
	public Card(Integer face, Suits suit){
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

	public Integer getFace() {
		return face;
	}

	public void setFace(Integer face) {
		this.face = face;
	}
}

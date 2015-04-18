package klondike;

public class FullDeck {
	
	public Integer[] face = {1,2,3,4,5,6,7,8,9,10,11,12,13,
							 1,2,3,4,5,6,7,8,9,10,11,12,13,
							 1,2,3,4,5,6,7,8,9,10,11,12,13,
							 1,2,3,4,5,6,7,8,9,10,11,12,13};

	public Suits[] suit = {Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,
							Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,
							Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,
							Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,
							Suits.DIAMONDS,Suits.DIAMONDS,Suits.DIAMONDS,Suits.DIAMONDS,Suits.DIAMONDS,Suits.DIAMONDS,Suits.DIAMONDS,
							Suits.DIAMONDS,Suits.DIAMONDS,Suits.DIAMONDS,Suits.DIAMONDS,Suits.DIAMONDS,Suits.DIAMONDS,
							Suits.CLUBS,Suits.CLUBS,Suits.CLUBS,Suits.CLUBS,Suits.CLUBS,Suits.CLUBS,Suits.CLUBS,
							Suits.CLUBS,Suits.CLUBS,Suits.CLUBS,Suits.CLUBS,Suits.CLUBS,Suits.CLUBS};
	
	public boolean[] used = {false,false,false,false,false,false,false,false,false,false,false,false,false,
							 false,false,false,false,false,false,false,false,false,false,false,false,false,
							 false,false,false,false,false,false,false,false,false,false,false,false,false,
							 false,false,false,false,false,false,false,false,false,false,false,false,false,};
	
}

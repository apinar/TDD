package klondike;

public class FullDeck {
	
	public String[] face = {"1","2","3","4","5","6","7","8","9","10","J","Q","K",
								"1","2","3","4","5","6","7","8","9","10","J","Q","K",
								"1","2","3","4","5","6","7","8","9","10","J","Q","K",
								"1","2","3","4","5","6","7","8","9","10","J","Q","K"};

	public Suits[] suit = {Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,
							Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,Suits.SPADES,
							Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,Suits.HEARTS,
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

import java.util.*; 
/**
 * represents a collection of cards 
 * and the functions associated with a group of cards
 * @author helen yue
 *
 */
public class Deck {
	
	//a deck is an arrayList of cards because we need to modify the size 
	//as the cards are dealt 
	ArrayList<Card> deck; 
	
	/**
	 * Constructor for Deck class.
	 * Automatically creates a collection of 52 cards of 4 suites and 13 ranks per suite. 
	 * Usage: Deck d = new Deck(); 
	 */
	Deck () {
		//a deck is an array of 52 cards of 4 suites and 13 ranks per suite;
		deck = new ArrayList<Card>(); 
		
		String[] suites = {"D", "C", "H", "S"}; 
		
		String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; 
		
			for(int j = 0; j < suites.length; ++j) {
				
				for(int k = 0; k < ranks.length; ++k) {
					
					Card newCard = new Card(ranks[k], suites[j]);
					deck.add(newCard);  
				
				}
			}
				
	}
	
	/**
	 * shuffles the deck at any given time
	 */
	
	void shuffle() {
		
		//for testing
		System.out.println("Shuffling..."); 
		
		//for actual
		Collections.shuffle(deck); 
		
		System.out.println("\n");
	}
	
	/**
	 * returns the "topmost" or first card of the deck
	 * and removes it from the deck 
	 * @return a new card
	 */
	Card deal() {
			
		Card nextCard = deck.get(0);
		
		deck.remove(0); 
		return nextCard; 
	}
	
	/**
	 * prints the deck at any given time (in 1 line)
	 * for testing
	 *
	 */
	void printDeck() {
		
		for (Card c:deck) {
			System.out.print(c.description + " "); 
		}
		
		System.out.println(""); 
		//for testing
		System.out.println("There are " + deck.size() + " cards in the deck."); 
		
		
	}
	

}

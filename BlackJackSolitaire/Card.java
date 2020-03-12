	/**
	 * A card has a suite, denoted D for Diamond, 
	 * C for club, H for heart, and S for spade, 
	 * 
	 * and a rank, denoted: 
	 * A for Ace, 2, ... , 10 as usual, 
	 * and J for Jack, Q for Queen, K for King
	 * 
	 * The description is used to easily display the card's 
	 * properties
	 */
public class Card {
	
	String suite; 
	String rank; 
	String description; 
	
	//constructor 
	
	/**
	 * Creates a card with a given rank and suite
	 * @param rank
	 * @param suite
	 */
	Card(String rank, String suite){
		
		this.suite = suite; 
		this.rank = rank;
		this.description = this.rank + this.suite; 
		
	}
	

}

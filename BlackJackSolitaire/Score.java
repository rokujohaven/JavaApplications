import java.util.ArrayList;

/**
 * Some useful functions to score the board
 * @author helen yue
 *
 */
public class Score {
	
	//score hands 2 down
	//3 across
	//4 down
	//5 across
	
	//sum up the scores in a score function 
	
	/**
	 * calculates the sum of the rank for a vertical pair of cards
	 * @param board the list of boardObjects
	 * @param startPosition the position on the board we wish to start calculating from
	 * @return the sum of the rank for a vertical pair of cards
	 */
	
	int twoDown(BoardObject[] board, int startPosition) {
		
		Integer score = 0;
		
		//we first put the aces in a separate list, then deal with it 
		//after we have the scores from the numeric ranks. 
		
		ArrayList<Card> Aces = new ArrayList<Card>();  
	
		for(int i = startPosition; i < startPosition + 6; i=i+5) {
			if (board[i-1].card.rank.equals("A")) {
				Aces.add(board[i-1].card);  
				
			}
			else {
			score = score + returnIntegerRank(board[i-1].card); 
			}
		}
	
		//if there are any Aces 
		if(Aces.size() > 0) {
			
			for(int i = 0; i < Aces.size(); ++i) {
				
				if(score < 11) {
					score = score + 11;
				}
				else { //should always be 12 since must be a double ace
					score = score + 1; 
				}
				
			}
		
		
		}

		return score; 
		
	}
	/**
	 * calculates sum of the rank for a vertical group of 4 cards
	 * @param board a list of boardObjects
	 * @param startPosition the starting location on the board
	 * @return the sum of the rank for a vertical group of 4 cards
	 */
	int fourDown(BoardObject[] board, int startPosition) {
		
		Integer score = 0;
		
		//we first put the aces in a separate list, then deal with it 
		//after we have the scores from the numeric ranks. 
		ArrayList<Card> Aces = new ArrayList<Card>();  
		
		Card currentCard = board[startPosition-1].card; 
		
		//check if first one is Ace. 
		if (currentCard.rank.equals("A")) {
			Aces.add(currentCard);  
			
		}
		else {
			score = score + returnIntegerRank(currentCard);	
		}
		 
		int step = 5; 
		
		//check to see if any other card in the group contains an Ace
		//if the first one is not. 
		//calculated non-Ace scores 
		int currentPosition = (startPosition-1)+step; 
		
			for(int i = 0; i < 3; ++i) {
				
				currentCard = board[currentPosition].card;
				if (currentCard.rank.equals("A")) {
					Aces.add(currentCard); 
				}
				else {
					score = score + returnIntegerRank(currentCard); 			
				}
	
				step--;
				currentPosition = currentPosition + step; 
			}
			
		
		//then determine Ace Value, if any
			if(Aces.size() > 0) { 
				
				for(int i = 0; i < Aces.size(); ++i) {
					//if existing score is 21 or more already, 
					//the hand is bust (0 points)
					if(score >= 21) {
						score = score + 1; 
					}
					//if score < 11, Ace can be 11
					else if(score < 11) {
						score = score + 11; 
					}
					//if score between 11 and 20, Ace is just 1
					else {
						score = score + 1;
					}
					
				}
			
			}

		return score; 
	}
	
	/**
	 * calculates sum of the rank for a hand of size 3 or 5 that is across 
	 * @param board a list of boardObjects
	 * @param startPosition starting location of the hand on the board
	 * @param numAcross either 3 or 5 group of cards
	 * @return sum of the rank for a hand of size 3 or 5 that is across
	 */
	int across(BoardObject[] board, int startPosition, int numAcross) {
		Integer score = 0; 
		ArrayList<Card> Aces = new ArrayList<Card>();  
		
		int step = 0; 
		
		for(int i = 0; i < numAcross; ++i) {
			Card currentCard = board[(startPosition-1) + step].card; 
			if(currentCard.rank.equals("A")) {
				Aces.add(currentCard);
			}
			else {
				score = score + returnIntegerRank(currentCard); 
			}
			step++;
		}
		
		//then determine Ace Value, if any
		if(Aces.size() > 0) { //if there's at least 1 Ace
			
			for(int i = 0; i < Aces.size(); ++i) {
				//if existing score is 21 or more already, 
				//the hand is bust (0 points)
				if(score >= 21) {
					score = score + 1; 
				}
				//if score < 11, Ace can be 11
				else if(score < 11) {
					score = score + 11; 
				}
				//if score between 11 and 20, Ace is just 1
				else {
					score = score + 1;
				}
				
			}
		
		}
		
		return score; 
	}
	
	/**
	 * Converts the card's string rank to an integer for scoring the card.
	 * For Jack, Queen, King, value is 10.
	 * Does NOT deal with Aces! DO NOT USE WITH AN ACE CARD. 
	 * @param card: takes a card
	 * @return the integer value associated with the card
	 */
	int returnIntegerRank(Card card) {
		
		if(card.rank.equals("J") || card.rank.equals("Q") || card.rank.equals("K")) {
			return 10; 
		}
		//otherwise return integer rank (Do not use with Ace!)
		return Integer.parseInt(card.rank); 
	}
	
	/**
	 * converts the sum of the rank to the number of points awarded for each hand
	 * @param score the sum of the ranks in the hand
	 * @param numCards the number of cards in the hand
	 * @return total points awarded for the hand
	 */
	int scoreToPoints(int score, int numCards) {
		if(score == 20 && (numCards == 2 ||numCards == 3 || numCards == 4 || numCards == 5)) {
			return 5; 
		}
		else if(score == 19 && (numCards == 2 ||numCards == 3 || numCards == 4 || numCards == 5)) {
			return 4; 
		}
		else if(score == 18 && (numCards == 2 ||numCards == 3 || numCards == 4 || numCards == 5)) {
			return 3; 
		}
		else if(score == 17 && (numCards == 2 ||numCards == 3 || numCards == 4 || numCards == 5)) {
			return 2;
		}
		else if(score <= 16 && score >= 0 && (numCards == 2 ||numCards == 3 || numCards == 4 || numCards == 5)) {
			return 1; 
		}
		else if(score > 21 && score < 0 && (numCards == 2 ||numCards == 3 || numCards == 4 || numCards == 5)) {
			return 0; 
		}
		//score = 21
		else {
			if(numCards == 2 && score == 21) {
				return 10; 
			}
			else if((numCards == 3 || numCards == 4 || numCards == 5) && score == 21) {
				return 7; 
			}
			else {
				return 0; 
			}
		}
	}
	
	/**
	 * gets the total points for the entire board
	 * @param board a list of boardObjects
	 */
	void boardScore(BoardObject[] board) {
		
		int sum = 0;
		
		for(int i = 1; i < 7; i = i + 4) {
			sum = sum + scoreToPoints(twoDown(board, i),2);
		}
		
		
		for(int i = 2; i < 5; ++i) {
			sum = sum + scoreToPoints(fourDown(board,i),4);
		}
		
		for(int i = 1; i < 7; i = i+5) {
			sum = sum + scoreToPoints(across(board,i,5),5);
		}
		
		
		for(int i = 11; i < 15; i = i+3) {
			sum = sum + scoreToPoints(across(board, i ,3),3);
		}
		
		System.out.println("Total number of points is: " + sum); 
		System.out.println("The game is done."); 
	}
	
	
	
}

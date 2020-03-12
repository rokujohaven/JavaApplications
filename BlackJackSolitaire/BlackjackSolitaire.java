import java.util.*; //for ArrayList
/**
 * This class operates one hand of blackjack solitaire
 * @author helen yue
 *	
 */
public class BlackjackSolitaire {

	//represents actual hand that is selected. Will be used for scoring. 
	ArrayList<Card> hand = new ArrayList<Card>();
	/**
	 * runs the main steps of play for one hand
	 */
	void play() {
		
		//INITIAL SETUP------------------------------
		
		//creates a board of 20 card locations and the actual cards
		BoardObject[] board = new BoardObject[20];
		
		System.out.println("Setting up a new board..."); 
		initialize(board); 
		
		printBoard(board);
		
		//initialize deck
		System.out.println("Setting up a new deck...");
		Deck deck = new Deck();
		
		//shuffle deck 
		deck.shuffle();
		
		//we end the game when the hand is of size 16. 
		
		//USER INPUT (PLAY)--------------------------------------
		Scanner s = new Scanner(System.in);
		
		int requestedPosition; 
		
		boolean handComplete = false; 
		
		while(!handComplete) {
			
			Card currentCard = deck.deal(); 
			
			boolean successfulPlacement = false; 
			
			
			
			while(!successfulPlacement) {
				
			System.out.println("Your current card is " + currentCard.description
					+ "\n\nPlease enter an empty integer location on the board \n"
					+ "to place it!");
			
			requestedPosition = s.nextInt();
			
			successfulPlacement = place(currentCard, requestedPosition, board);	
			
			}
			
			
			System.out.println("OK. Now printing the updated board...\n"); 
			
			printBoard(board);
			
			System.out.println("\n-----------------------------\n");
			
			if(hand.size() == 16) {
				handComplete = true; 
			}
		}
		
		
		
		s.close(); 
		
		//SCORING ----------------------------------------------------
		
		System.out.println("Now we will score the board..."); 
		
		Score score = new Score(); 
		
		//POINTS----------
		
		score.boardScore(board);
		
	}
	
	//-----------individual game actions: -----------------//
	
	/**
	 * initialize board at beginning of game
	 * @param board which is a list of boardObjects
	 */
	
	void initialize(BoardObject[] board) {
		
		for(int i = 0; i < board.length; ++i) {
				
				//must declare new object, or will throw Null Pointer exception
				board[i] = new BoardObject(); 
				
				board[i].position = i+1; 
				board[i].card = new Card("0","0"); 
				
			}
		}
	
	/**
	 * given a card, puts it on the board at a desired position.
	 * @param newCard is a new card that is dealt
	 * @param position is the desired position on the board
	 * @param board is the current list of boardObjects
	 * @return true if the card is placed successfully, false if not placed
	 */
	boolean place(Card newCard, int position, BoardObject[] board) {
		
		//if the desired position is empty and not a part of the discard pile
		//put it in the hand 
		if(position < 17 && isValidPosition(position, board)) {
			board[position - 1].card = newCard; 
			hand.add(newCard); 
			return true; 
		}
		//otherwise if the desired position is empty and a part of the discard pile
		else if(position > 16 && position < 21 && isValidPosition(position, board)){
			board[position - 1].card = newCard; 
			return true; 
		}
		else {
			System.out.println("Invalid Position"
					+ " (you either specified a location not on board, \n"
					+ "or a position that is filled already!)\n"); 
			return false;
		}
		
	}
	
	/**
	 * checks if the user enters the number of a spot that already has a card
	 * @param position the desired position on the board
	 * @param board the current list of boardObjects
	 * @return true if the position is still empty, false if not
	 */
	boolean isValidPosition(int position, BoardObject[] board) {
		
		if(position == 0 || position < 0){
			return false;
		}
		else if(board[position - 1].card.description.equals("00")) {
			return true; 
		}
		return false; 
	}
	
	
	/**
	 * prints the board at any given time
	 * @param board which is a list of boardObjects
	 */
	void printBoard(BoardObject[] board) {
		
		//System.out.println("Printing board...");
		//prints 2 rows of 5 pieces each 
		int i = 0; 
		while( i < 10) {
			int column_counter = 0; 
			while (column_counter < 5) {
				//if board has not been initiated, just print out the position.
				if(board[i].card.description.equals("00")) {
					System.out.print(board[i].position + "         ");
					i++;
					}
				//otherwise, print out the card description
				else {
					System.out.print(board[i].card.description + "         ");
					i++;
				}
				column_counter++; 
			}
			System.out.println();	
		}
		
		//prints 2 rows of 3 pieces each
		while(i<16) {
			System.out.print("          ");
			int column_counter = 0; 
			while(column_counter < 3) {
				//if board has not been initiated, just print out the position.
				if(board[i].card.description.equals("00")) {
					System.out.print(board[i].position + "        ");
					i++;
					}
				//otherwise, print out the card description
				else {
					System.out.print(board[i].card.description + "        ");
					i++;
				}
				column_counter++; 
				
			}
		System.out.println();
		}
		
		//prints the discard pile
		
		System.out.println("DISCARD PILE: "); 
		while(i < 20) {
			
			//if board has not been initiated, just print out the position.
			if(board[i].card.description.equals("00")) {
				System.out.print(board[i].position + "   ");
				i++;
				}
			//otherwise, print out the card description
			else {
				System.out.print(board[i].card.description + "   ");
				i++;
			}
			
		}
		
		//skips space to denote end of printing board
		System.out.println("\n");
	
		
	}

	
}

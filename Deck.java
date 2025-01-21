package poker;

public class Deck {
	/*This class represents the deck of cards. The deck, other deck, get card
	 * at get number of cards, shuffle, cut, deal and is even. */

	/*Initialized an array of cards. */
	private Card[] cards; 

	/*Max number of cards in a deck is 52. */
	private final static int MAX_NUMBER_OF_CARDS = 52;

	/*Initialized the max number of cards(52) as an object. */
	public Deck() {
		cards = new Card[MAX_NUMBER_OF_CARDS];

		int currentIndex = 0;

		/*Suits: Spades, Hearts, Clubs, Diamonds. */
		for (int suit = 0; suit <= 3 ; suit++) {
			/*Values: 1 through 13 (1 is Ace, 11 is jack, 12 is queen, 13
			 * is king, 2 through 10 represent card values 2 through 10.*/
			for (int value = 1; value <= 13 ; value++) {

				cards[currentIndex++] = new Card(value, suit);

			}
		}

	}

	/* Calling the copy constructor for the deck of cards. */
	public Deck(Deck other) {
		if(other == null) throw new IllegalArgumentException
		("The other argument in the copy constructor is null");

		int numberOfCardsInOther = other.getNumCards();

		cards = new Card[numberOfCardsInOther];

		for (int i = 0; i < cards.length; i++) {
			cards[i] = other.getCardAt(i);
		}
	}

	/*The returns the card at a specific position of the card array. */
	public Card getCardAt(int position) {
		if(position < 0 || position > cards.length)
			throw new ArrayIndexOutOfBoundsException
			("Cannot get card because the position of the card is out of "
					+ "bounds");

		return cards[position];
	}

	/*This Getter returns the size of the card array. */
	public int getNumCards() {
		return cards.length;
	}

	/*This method rearranges the cards in the deck. */
	public void shuffle() {
		int deckLength = cards.length;
		int topLength = deckLength / 2;
		int bottomLength = deckLength / 2;


		if(!isEven(deckLength))
			topLength = ((deckLength / 2) + 1);

		int bottomPointer = topLength;
		Card[] top = new Card[topLength];
		Card[] bottom = new Card[bottomLength];

		for (int i = 0; i < top.length; i++) {
			top[i] = cards[i];
		}

		for (int i = 0; i < bottom.length; i++) {
			bottom[i] = cards[bottomPointer++];
		}

		Card[] temporaryCards = new Card[cards.length];
		int t = 0, b = 0;
		for (int a = 0; a < temporaryCards.length; a++) {
			if(isEven(a))
			{
				temporaryCards[a] = top[t++];
			}else{
				temporaryCards[a] = bottom[b++];
			}
		}

		cards = new Card[temporaryCards.length];
		for (int i = 0; i < temporaryCards.length; i++) {
			cards[i] = temporaryCards[i];
		}
	}

	/*This methods divides the cards into 2 different decks. */
	public void cut(int position) {
		if(position < 0 || position > cards.length) 
			throw new ArrayIndexOutOfBoundsException
			("Cannot cut cards because the position of the card is out of "
					+ "bounds");

		Card[] temporaryCards = new Card[cards.length];

		int location = 0;
		for (int a = position; a < cards.length; a++) {
			temporaryCards[location++] = cards[a];
		}

		for (int b = 0; b < position; b++) {
			temporaryCards[location++] = cards[b];
		}

		cards = new Card[temporaryCards.length];
		for (int d = 0; d < cards.length; d++) {
			cards[d] = temporaryCards[d];
		}

	}

	/*This method removes a number of cards from the top of the deck then 
	 * returns them as an array. */
	public Card[] deal(int numCards) {
		if(numCards < 0 || numCards > cards.length) 
			throw new ArrayIndexOutOfBoundsException
			("Cannot deal cards because the numCards is out of bounds");

		Card[] dealtHand = new Card[numCards];
		for (int a = 0; a < dealtHand.length; a++) {
			dealtHand[a] = cards[a];
		}

		int smallerSize = cards.length - numCards;
		Card[] smaller = new Card[smallerSize];
		int index = 0;

		for (int b = numCards; b < cards.length; b++) {
			smaller[index++] = cards[b];
		}

		cards = new Card[smaller.length];
		for (int c = 0; c < smaller.length; c++) {
			cards[c] = smaller[c];
		}

		return dealtHand;
	}
	/*This method returns true if a number is evenly divided by 2, if not it 
	 * returns false.*/
	private static boolean isEven(int number){
		if(number % 2 == 0) {
			return true;
		}else{
			return false;
		}
	}

}

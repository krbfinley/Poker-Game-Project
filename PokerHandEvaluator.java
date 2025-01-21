package poker;

public class PokerHandEvaluator {
	/*This class represents the different types of hands in poker. Pair,two pair,
	 * three of a kind,straight,flush,full house,four of a kind, straight flush.*/

	/*Static final int ACE and KING will be used in the method hasStraight.*/
	private static final int ACE = 1;
	private static final int KING = 13;

	/*Where two of the cards are the same value. */
	public static boolean hasPair(Card[] cards){ 
		for (int i = 0; i < cards.length; i++){
			for (int j = i + 1; j < cards.length; j++){
				if(cards[i].getValue() == cards[j].getValue()){

					return true;
				}
			}
		}

		return false;
	}
	/*Where there are two pairs with the same value. */
	public static boolean hasTwoPair(Card[] cards){ 
		int count = 0;
		int firstPairValue = -1;

		for (int i = 0; i < cards.length; i++){
			count = 1;

			for (int j = i + 1; j < cards.length; j++){

				if(cards[i].getValue() == cards[j].getValue()){
					count++;

					if(count == 2){
						firstPairValue = cards[i].getValue();

					}
				}
			}
		}
		for (int i = 0; i < cards.length; i++){
			count = 1;

			for (int j = i + 1; j < cards.length; j++){

				if(cards[i].getValue() == cards[j].getValue() && 
						cards[i].getValue() != firstPairValue){
					count++;

					if(count == 2){
						return true;
					}
				}
			}
		}
		return false;
	}

	/*Where three of the cards are the same value. */
	public static boolean hasThreeOfAKind(Card[] cards){
		int count = 0;

		for (int i = 0; i < cards.length; i++) {
			count = 1;

			for (int j = (i + 1); j < cards.length; j++){

				if(cards[i].getValue() == cards[j].getValue()){
					count++;

					if(count == 3){

						return true;
					}
				}
			}
		}
		return false;
	}

	/*Where five cards with values are consecutive. */
	public static boolean hasStraight(Card[] cards){ //...
		Card [] tmpCards = copyCardArray(cards);

		Card [] orderedCards = new Card[cards.length];
		int pos = 0;

		for (int i = 0; i < cards.length; i++){

			Card card = findMinimumAndModifyArray(tmpCards);
			orderedCards[pos++] = card;
		}

		boolean isConsecutive = true;

		if(orderedCards[0].getValue() == ACE){
			if(orderedCards[orderedCards.length - 1].getValue() != KING &&
					orderedCards[1].getValue() != 2){
				return false;
			}
			for (int i = 2; i < cards.length; i++){
				if((orderedCards[i].getValue() - 
						orderedCards[i-1].getValue() != 1)){
					return false;
				}
			}
		}else{
			for (int i = 1; i < cards.length; i++) {
				if((orderedCards[i].getValue() - 
						orderedCards[i-1].getValue() != 1)){

					return false;
				}
			}
		}

		return isConsecutive;
	}
	/*Where five cards have the same suit. */
	public static boolean hasFlush(Card[] cards){
		int count = 0;

		for (int i = 0; i < cards.length; i++){
			for (int j = 0; j < cards.length; j++){

				if(cards[i].getSuit() != cards[j].getSuit()){
					return false;
				}else{
					count++;

					if(count == 5)
					{
						return true;
					}
				}
			}
		}
		return false;
	}

	/*Where a pair of cards share the same value, and the other three cards 
	 * share another value. */
	public static boolean hasFullHouse(Card[] cards){
		Card [] tmpCards = copyCardArray(cards);

		Card [] orderedCards = new Card[cards.length];
		int pos = 0;

		if(cards.length < 5) {
			return false;
		}
		for (int i = 0; i < cards.length; i++) {

			Card card = findMinimumAndModifyArray(tmpCards);
			orderedCards[pos++] = card;
		}

		boolean pairAtFront = (orderedCards[0].getValue() ==
				orderedCards[1].getValue());

		boolean pairAtBack = (orderedCards[3].getValue() == 
				orderedCards[4].getValue());

		boolean centerMatch = (orderedCards[2].getValue() == 
				orderedCards[1].getValue()) || (orderedCards[2].getValue() == 
				orderedCards[3].getValue());

		return (pairAtBack && pairAtFront && centerMatch);
	}

	/*Where four of the cards are the same value.*/
	public static boolean hasFourOfAKind(Card[] cards){ 
		int count = 0;

		for (int i = 0; i < cards.length; i++){
			count = 1;

			for (int j = i + 1; j < cards.length; j++){

				if(cards[i].getValue() == cards[j].getValue()){

					count++;
				}
			}
			if(count >= 4){

				return true;
			}
		}
		return false;
	}

	/*Where five cards with values are consecutive and those five cards have
	 * the same suit. */
	public static boolean hasStraightFlush(Card[] cards){ 
		/*Straight + Flush*/
		boolean isStraight = hasStraight(cards);

		boolean isFlush = hasFlush(cards);

		return (isStraight && isFlush);
	}

	/*Deep copy of the array of cards. */
	private static Card[] copyCardArray(Card[] cards){
		Card[] result = new Card[cards.length];
		int pos = 0;

		for (int i = 0; i < cards.length; i++){

			Card element = cards[i];
			Card newCard = new Card(element.getValue(), element.getSuit());
			result[pos++] = newCard;
		}

		return result;
	}

	/*Returning the minimum value from the array that is NOT null. */
	private static Card findMinimumAndModifyArray(Card[] cards){

		Card min = new Card(13,3);
		int finPos = 0;
		for (int i = 0; i < cards.length; i++){
			if(cards[i] == null) continue;
			if (cards[i].getValue() <= min.getValue()){
				min = cards[i];
				finPos = i;
			}

		}
		cards[finPos] = null;
		return min;
	}
}

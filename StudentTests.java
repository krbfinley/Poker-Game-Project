package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTests {


	@Test
	public void testShuffle(){
		Deck a = new Deck();
		a.shuffle();
		assertTrue(a.getCardAt(0).getSuit() == 0);
		assertTrue(a.getCardAt(0).getValue() == 1);
	}
	@Test
	public void testHasPair(){ // value, suit
		Card n = new Card (13,3);
		Card n1 = new Card (13,0);
		Card n2 = new Card (12,1);
		Card n3 = new Card (3,1);
		Card n4 = new Card (1,0);
		Card[] arr = {n,n1,n2,n3,n4};
		assertTrue(PokerHandEvaluator.hasPair(arr));

		Card n5 = new Card(1,1);
		Card n6 = new Card(2,1);
		Card n7 = new Card(3,3);
		Card n8 = new Card(4,2);
		Card n9 = new Card(5,0);
		Card[] arr2 = {n5,n6,n7,n8,n9};
		assertFalse(PokerHandEvaluator.hasPair(arr2));
	}
	@Test
	public void testHasTwoPair(){ // value, suit
		Card n = new Card(11,2);
		Card n1 = new Card(5,3);
		Card n2 = new Card(8,1);
		Card n3 = new Card(5,0);
		Card n4 = new Card(11,0);
		Card[] arr = {n,n1,n2,n3,n4};
		Card n5 = new Card(13,2);
		Card n6 = new Card(5,3);
		Card n7 = new Card(5,1);
		Card n8 = new Card(5,0);
		Card n9 = new Card(12,0);
		Card[] arr2 = {n5,n6,n7,n8,n9};
		assertTrue(PokerHandEvaluator.hasTwoPair(arr));
		assertFalse(PokerHandEvaluator.hasTwoPair(arr2));	
	}
	@Test
	public void testHasThreeOfAKind(){ //
		Card n = new Card(8,1);
		Card n1 = new Card(11,0);
		Card n2 = new Card(2,0);
		Card n3 = new Card(8,0);
		Card n4 = new Card(8,3);
		Card[] arr = {n,n1,n2,n3,n4};
		Card n5 = new Card(11,1);
		Card n6 = new Card(11,0);
		Card n7 = new Card(2,0);
		Card n8 = new Card(8,0);
		Card n9 = new Card(8,3);
		Card[] arr2 = {n5,n6,n7,n8,n9};
		assertTrue(PokerHandEvaluator.hasThreeOfAKind(arr));
		assertFalse(PokerHandEvaluator.hasThreeOfAKind(arr2));
	}
	@Test
	public void testStraight(){ // value, suit
		Card n = new Card(5,1);
		Card n1 = new Card(6,1);
		Card n2 = new Card(7,1);
		Card n3 = new Card(8,1);
		Card n4 = new Card(9,1);

		Card n5 = new Card(1,1);
		Card n6 = new Card(2,1);
		Card n7 = new Card(3,1);
		Card n8 = new Card(4,2);
		Card n9 = new Card(5,0);
		Card[] arr = {n,n1,n2,n3,n4};
		Card [] arr2 = {n8,n7,n9,n6,n5};
		assertTrue(PokerHandEvaluator.hasStraight(arr));	
		assertTrue(PokerHandEvaluator.hasStraight(arr2));
	}
	@Test
	public void testFlush(){ // value, suit
		Card n = new Card(9,3);
		Card n1 = new Card(8,3);
		Card n2 = new Card(7,3);
		Card n3 = new Card(6,3);
		Card n4 = new Card(5,3);
		Card[] arr = {n,n1,n2,n3,n4};
		assertTrue(PokerHandEvaluator.hasFlush(arr));		
	}
	@Test
	public void testFullHouse(){ // value, suit
		Card n = new Card(7,1);
		Card n1 = new Card(7,3);
		Card n2 = new Card(12,3);
		Card n3 = new Card(7,0);
		Card n4 = new Card(12,0);
		Card[] arr = {n,n1,n2,n3,n4};
		Card n5 = new Card(13,3);
		Card n6 = new Card(13,3);
		Card n7 = new Card(5,3);
		Card n8 = new Card(5,1);
		Card n9 = new Card(13,3);
		Card[] arr2 = {n5,n6,n7,n8,n9};
		assertTrue(PokerHandEvaluator.hasFullHouse(arr));	
		assertTrue(PokerHandEvaluator.hasFullHouse(arr2));	
	}
	@Test
	public void testHasFourOfAKind(){ //value, suit
		Card n = new Card(7,0);
		Card n1 = new Card(7,1);
		Card n2 = new Card(2,0);
		Card n3 = new Card(7,3);
		Card n4 = new Card(7,2);
		Card[] arr = {n,n1,n2,n3,n4};
		Card n5 = new Card(12,3);
		Card n6 = new Card(13,3);
		Card n7 = new Card(5,3);
		Card n8 = new Card(13,1);
		Card n9 = new Card(13,3);
		Card[] arr2 = {n5,n6,n7,n8,n9};
		assertTrue(PokerHandEvaluator.hasFourOfAKind(arr));
		assertFalse(PokerHandEvaluator.hasFourOfAKind(arr2));
	}
	@Test
	public void testStraightFlush(){ //value, suit
		Card n = new Card(4,3);
		Card n1 = new Card(5,3);
		Card n2 = new Card(6,3);
		Card n3 = new Card(7,3);
		Card n4 = new Card(8,3);

		Card n5 = new Card(1,1);
		Card n6 = new Card(2,1);
		Card n7 = new Card(3,1);
		Card n8 = new Card(4,1);
		Card n9 = new Card(5,1);

		Card n10 = new Card(12,1);
		Card n11 = new Card(13,1);
		Card n12 = new Card(1,1);
		Card n13 = new Card(2,1);
		Card n14 = new Card(3,1);

		Card[] arr = {n,n1,n2,n3,n4};
		Card [] arr2 = {n8,n7,n9,n6,n5};
		Card [] arr3 = {n10,n12,n13,n14,n11};

		assertTrue(PokerHandEvaluator.hasStraightFlush(arr));
		assertTrue(PokerHandEvaluator.hasStraightFlush(arr2));
		assertFalse(PokerHandEvaluator.hasStraightFlush(arr3));
	}
}

	
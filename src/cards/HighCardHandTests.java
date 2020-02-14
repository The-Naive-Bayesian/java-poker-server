package cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HighCardHandTests {
  @Test
  void compareLess() {
    CardCollection cardsLess = new CardCollection();
    cardsLess.add(new Card(FaceValue.KING, Suite.DIAMOND));
    cardsLess.add(new Card(FaceValue.JACK, Suite.DIAMOND));

    CardCollection cardsGreater = new CardCollection();
    cardsGreater.add(new Card(FaceValue.ACE, Suite.HEART));
    cardsGreater.add(new Card(FaceValue.QUEEN, Suite.HEART));

    HoldemHand handLess = new HighCardHand(cardsLess);
    HoldemHand handGreater = new HighCardHand(cardsGreater);

    assertTrue(handLess.compareTo(handGreater) < 0);
  }

  @Test
  void compareGreater() {
    CardCollection cardsGreater = new CardCollection();
    cardsGreater.add(new Card(FaceValue.KING, Suite.CLUB));
    cardsGreater.add(new Card(FaceValue.JACK, Suite.CLUB));

    CardCollection cardsLess = new CardCollection();
    cardsLess.add(new Card(FaceValue.TEN, Suite.SPADE));
    cardsLess.add(new Card(FaceValue.QUEEN, Suite.SPADE));

    HoldemHand handGreater = new HighCardHand(cardsGreater);
    HoldemHand handLess = new HighCardHand(cardsLess);

    assertTrue(handGreater.compareTo(handLess) > 0);
  }

  @Test
  void compareEqual() {
    CardCollection cards1 = new CardCollection();
    cards1.add(new Card(FaceValue.QUEEN, Suite.CLUB));
    cards1.add(new Card(FaceValue.TEN, Suite.CLUB));

    CardCollection cards2 = new CardCollection();
    cards2.add(new Card(FaceValue.TEN, Suite.SPADE));
    cards2.add(new Card(FaceValue.QUEEN, Suite.SPADE));

    HoldemHand hand1 = new HighCardHand(cards1);
    HoldemHand hand2 = new HighCardHand(cards2);

    assertEquals(hand1.compareTo(hand2), 0);
  }
}

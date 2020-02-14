package cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoldemHandServiceTests {
  @Test
  void buildsHand() {
    CardCollection cards = new CardCollection();
    cards.add(new Card(FaceValue.QUEEN, Suite.CLUB));
    cards.add(new Card(FaceValue.TEN, Suite.SPADE));
    cards.add(new Card(FaceValue.NINE, Suite.HEART));
    cards.add(new Card(FaceValue.ACE, Suite.DIAMOND));
    cards.add(new Card(FaceValue.FIVE, Suite.CLUB));
    cards.add(new Card(FaceValue.SEVEN, Suite.CLUB));
    cards.add(new Card(FaceValue.ACE, Suite.CLUB));

    HoldemHandService.getBestHand(cards);
  }

  @Test
  void buildsBestHighCardHand() {
    CardCollection cards = new CardCollection();
    cards.add(new Card(FaceValue.QUEEN, Suite.CLUB));
    cards.add(new Card(FaceValue.TEN, Suite.SPADE));
    cards.add(new Card(FaceValue.NINE, Suite.HEART));
    cards.add(new Card(FaceValue.ACE, Suite.DIAMOND));
    cards.add(new Card(FaceValue.FIVE, Suite.CLUB));
    cards.add(new Card(FaceValue.SEVEN, Suite.CLUB));
    cards.add(new Card(FaceValue.TWO, Suite.CLUB));

    HoldemHand hand = HoldemHandService.getBestHand(cards);

    CardCollection handCards = hand.getCards();

    // This check assumes hand cards are sorted
    // TODO: remove this assumption
    Card[] expectedCards = {
      new Card(FaceValue.ACE, Suite.DIAMOND),
      new Card(FaceValue.QUEEN, Suite.CLUB),
      new Card(FaceValue.TEN, Suite.SPADE),
      new Card(FaceValue.NINE, Suite.HEART),
      new Card(FaceValue.SEVEN, Suite.CLUB),
    };

    int i = 0;
    for (Card card : handCards) {
      assertEquals(card.value, expectedCards[i].value);
      assertEquals(card.suite, expectedCards[i].suite);
      i++;
    }
  }
}

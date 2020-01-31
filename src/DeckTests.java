import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeckTests {
  private Deck deck;

  @BeforeEach
  void createDeck() {
    deck = new Deck();
  }

  @Test
  void canDrawCard() {
    Card card = deck.drawCard();

    assertNotNull(card);
  }

  @Test
  void drawingCardDecreasesDeckSize() {
    Integer initialSize = deck.size();

    deck.drawCard();

    assertEquals(deck.size(), initialSize - 1);
  }

  @Test
  void containsAllCards() {
    ArrayList<Card> cardsToCheck = new ArrayList<>();

    for (FaceValue value : FaceValue.values()) {
      for (Suite suite : Suite.values()) {
        Card card = new Card(value, suite);
        cardsToCheck.add(card);
      }
    }

    while (!deck.isEmpty()) {
      Card cardToCheck = deck.drawCard();

      int i = 0;
      for (Card card : cardsToCheck) {
        if (card.value == cardToCheck.value && card.suite == cardToCheck.suite) {
          cardsToCheck.remove(i);
          break;
        }
        i++;
      }
    }

    assertEquals(cardsToCheck.size(), 0);
  }
}

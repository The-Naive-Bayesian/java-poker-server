package cards;

import java.util.ArrayList;

public class Deck {
  private ArrayList<Card> cards;

  public Deck() {
    this.addAllCards();
    this.shuffle();
  }

  private void addAllCards() {
    cards = new ArrayList<>();

    for (FaceValue value : FaceValue.values()) {
      for (Suite suite : Suite.values()) {
        cards.add(new Card(value, suite));
      }
    }
  }

  private void shuffle() {
    // Use Fisher-Yates shuffle
    // https://bost.ocks.org/mike/shuffle/

    int size = cards.size();
    int remainingCards = size;

    for (int i=0; i<size; i++) {
      // Pick a random remaining element
      int targetIndex = (size - remainingCards) + (int)(Math.random() * remainingCards--);

      // Swap the card at the target index with the first card after the shuffled ones
      Card temp = cards.get(i);
      cards.set(i, cards.get(targetIndex));
      cards.set(targetIndex, temp);
    }
  }

  Card drawCard() {
    return cards.remove(cards.size() - 1);
  }

  Integer size() {
    return cards.size();
  }

  Boolean isEmpty() {
    return size() == 0;
  }
}

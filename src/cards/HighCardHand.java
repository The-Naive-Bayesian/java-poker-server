package cards;

import java.util.Iterator;

public class HighCardHand extends HoldemHand {
  HighCardHand(CardCollection cards) {
    this.type = HoldemHandType.HIGH_CARD;
    this.cards = cards;
  }

  @Override
  public int compareTo(HoldemHand other) {
    int compareResult = compareHandTypes(other);

    if (compareResult != 0) {
      return compareResult;
    }

    return compareCardValues(other);
  }

  private int compareHandTypes(HoldemHand other) {
    return type.compareTo(other.getType());
  }

  /**
   * Only relevant for high-card and flush hands
   */
  private int compareCardValues(HoldemHand other) {
    // Iterate through cards and return first nonzero compare result
    // If no cards left, return 0
    CardCollection otherCards = other.getCards();

    Iterator<Card> otherCardIterator = otherCards.iterator();

    for (Card card : cards) {
      int result = card.compareTo(otherCardIterator.next());

      if (result != 0) return result;
    }

    return 0;
  }
}

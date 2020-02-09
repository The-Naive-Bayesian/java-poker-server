import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class CardCollection implements Iterable<Card> {
  private Card[] cards;

  CardCollection(Card[] cards) {
    this.cards = cards;
  }

  void sort() {
    Arrays.sort(cards, Comparator.reverseOrder());
  }

  @Override
  public Iterator<Card> iterator() {
    return new CardIterator(cards);
  }

  private class CardIterator implements Iterator<Card> {
    private int index;
    private Card[] cards;

    CardIterator(Card[] cards) {
      this.cards = cards;
      index = 0;
    }

    @Override
    public boolean hasNext() {
      return index < cards.length;
    }

    @Override
    public Card next() {
      return cards[index++];
    }
  }
}

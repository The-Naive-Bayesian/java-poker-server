package cards;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class CardCollection implements Iterable<Card> {
  private ArrayList<Card> cards;

  public CardCollection() {
    this(new ArrayList<>());
  }

  public CardCollection(ArrayList<Card> cards) {
    this.cards = cards;
  }

  void add(Card card) {
    cards.add(card);
  }

  @Override
  public Iterator<Card> iterator() {
    cards.sort(Comparator.reverseOrder());
    return cards.listIterator();
  }
}
